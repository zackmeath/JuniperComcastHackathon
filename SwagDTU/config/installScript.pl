#!/usr/bin/perl
# Copyright (c) 2014 Juniper Networks. All rights reserved.
# Auto generated script. Please do not modify this file.  You can add custom changes in customInstallScript.pl.
#
# This installScript.pl is executed during app fresh install, upgrade or patch.  
# The purpose of this script is to perform app-specific operations during
# the install, upgrade and patch workflows.
# SDK re-deployment through the IDE is also considered as an upgrade.
# This script is called from /var/www/cgi-bin/swAppInstall script on the platform.
# The app packager extracts this script from the application's image
# and copies it to /var/www/cgi-bin folder where swAppInstall finds it.
#
# The script is called with parameters:
#
#		For example:  
#
#		installScript.pl upgrade platform /var/cache/jboss/jmp/payloads/WorldCities-1.0-99.99 1.0 1.0 13.3 R1 
#		(see parameter section, below, for explanation of parameters)
#
# Script log files: /var/log/install.log & /var/log/nma.log
#

use CGI;
use CGI::Carp qw ( fatalsToBrowser warningsToBrowser );
use warnings;
use File::Copy;
use lib ("/usr/nma/lib");
use NmaUtil;
use NmaUpgradeUtil;
use NmaDb;



$| = 1;  $ENV{"PATH"}="/bin:/sbin:/usr/bin:/usr/sbin";
$<=$>;

# Parameter Section:
my $action = $ARGV[0];				# add, upgrade or patch
my $serverGroup = $ARGV[1];			# platform or application (SDK apps use platform for now)
my $path = $ARGV[2];				# full directory path to app image in /var/cache/jboss/jmp/payloads/
my $currentVersion = $ARGV[3];		# current app version (for example: 1.0)
my $newVersion = $ARGV[4];			# new app version (for example: 1.1)
my $platformVersion = $ARGV[5];		# current actual platform version passed in from the platform (for example: 13.3)
my $release = $ARGV[6];				# release-type defined in the app-info.xml file (for example: R1)


# Define stdout and stderr log files
my $outLog = '/var/log/install.log';
my $errLog = '/var/log/install.log';

my $status = 0;

# Call appropriate sub depending on add/patch/upgrade
NmaUtil::ilog("installScript: calling installScript.pl: action=$action servergroup=$serverGroup path=$path currentVersion=$currentVersion newVersion=$newVersion platformVersion=$platformVersion release=$release");
if ($action eq "add") {
	NmaUtil::ilog( "installScript: installing a new application: SwagDTU");
	$status = &addApp($path);
}elsif( $action eq "patch" ) {
	NmaUtil::ilog("installScript: patching application: SwagDTU");
	$status = &patchApp($path, $currentVersion, $newVersion);
}elsif( $action eq "upgrade" ) {
	NmaUtil::ilog("installScript: upgrading application: SwagDTU");
    $status = &upgradeApp($path, $currentVersion, $newVersion);
}else {
	NmaUtil::ilog("installScript: invalid action: $action");
	$status = 1;
}

if ($status eq 0) {
	NmaUtil::ilog("SUCCESS");
}else {
	NmaUtil::ilog("FAILURE");
	die "installScript.pl failed with status $status!";
}


# Subroutine Section:

# Will be initialized in readProps() subroutine.
my %properties;

# Dynamically imports custom install script.  Since this script is installed by the rpm, it can't be loaded at compile time.
sub importCustomInstall {
	unshift @INC, "/var/www/cgi-bin/custom_SwagDTU";
	require customInstallScript; 
	customInstallScript->import();
}

# Read script.properties file and add script properties to properties hash
sub readProps() {
	# Initialize static properties
  	%properties = (
        "vendor" => "jssdk",
        "appName" => "SwagDTU",
        "action"=> "$action",
        "serverGroup" => "$serverGroup",
        "path" => "$path",
        "currentVersion" => "$currentVersion",
        "newVersion" => "$newVersion",
        "platformVersion" => "$platformVersion",
        "release" => "$release"
    );
   	# Initialize properties from app spec properties file
	open (MYFILE, "/var/www/cgi-bin/spec_SwagDTU.properties") or return; 
	while (<MYFILE>)
	{
	   chomp;
	   my ($key, $val) = split /=/;
	   $properties{$key} = $val;
	}
}


# Install a new app image (fresh install).
sub addApp {
	my $path = shift;
	my $error;

	$error = &installRpm($path);
	if ($error != 0) {
		return $error;
	}
	
	&importCustomInstall();
	&readProps();
	
	if (defined &customInstallScript::preInstall) {
		$error = customInstallScript::preInstall(\%properties);
		if ($error != 0) {
			return $error;
		}
	}
	
	if (defined &customInstallScript::createDB) {
		$error = customInstallScript::createDB(\%properties);
	} else {
		$error = &createDB(\%properties);
	}	
	if ($error != 0) {
		return $error;
	}
	
	if (defined &customInstallScript::addLog) {
		$error = customInstallScript::addLog(\%properties);
	} else {
		$error = &addLog(\%properties);
	}	
	if ($error != 0) {
		return $error;
	}

	if (defined &customInstallScript::addInfinispan) {
		$error = customInstallScript::addInfinispan(\%properties);
	} else {
		$error = &addInfinispan(\%properties);
	}	
	if ($error != 0) {
		return $error;
	}			

	$error = &deployEar();	
	if ($error != 0) {
		return $error;
	}

	if (defined &customInstallScript::postInstall) {
		$error = customInstallScript::postInstall(\%properties);
		if ($error != 0) {
			return $error;
		}
	}	
	return $error;
	
}

# Upgrade an existing app image.  This includes both version upgrade and SDK IDE reinstall (when version is the same).
sub upgradeApp {
	my $path = shift;
	my $vo = shift;
	my $vn = shift;
	
	my $error = &upgradePatchApp($path, $vo, $vn);
	if ($error != 0) {
		NmaUtil::ilog("installScript: ERROR Application SwagDTU upgrade failed with error: $error");
	} else {
		NmaUtil::ilog("installScript: Application SwagDTU successfully upgraded");
	}
	return $error;
	
}

# Upgrade app image to a new release type (Version number stays the same).
sub patchApp {
	my $path = shift;
	my $vo = shift;
	my $vn = shift;
	
	my $error = &upgradePatchApp($path, $vo, $vn);
	if ($error != 0) {
		NmaUtil::ilog("installScript: ERROR Application SwagDTU patch failed with error: $error");
	} else {
		NmaUtil::ilog("installScript: Application SwagDTU successfully patched");
	}	
	return $error;
}

# Used for both upgrade and patch.
sub upgradePatchApp {
	my $path = shift;
	my $vo = shift;
	my $vn = shift;
	
	NmaUtil::ilog("installScript: upgrade of SwagDTU from $vo to $vn");
		
	my $error = &upgradeRpm($path);
	if ($error != 0) {
		return $error;
	}
	
	&importCustomInstall();
	&readProps();

	if (defined &customInstallScript::preUpgrade) {
		$error = customInstallScript::preUpgrade(\%properties);
		if ($error != 0) {
			return $error;
		}
	}

	if (defined &customInstallScript::createDB) {
		$error = customInstallScript::createDB(\%properties);
	} else {
		$error = &createDB(\%properties);
	}	
	if ($error != 0) {
		return $error;
	}
	
	if (defined &customInstallScript::addLog) {
		$error = customInstallScript::addLog(\%properties);
	} else {
		$error = &addLog(\%properties);
	}	
	if ($error != 0) {
		return $error;
	}

	if (defined &customInstallScript::addInfinispan) {
		$error = customInstallScript::addInfinispan(\%properties);
	} else {
		$error = &addInfinispan(\%properties);
	}	
	if ($error != 0) {
		return $error;
	}			
	
	# migrate db on app version upgrade or patch
	if ($currentVersion ne $newVersion) {
		if (defined &customInstallScript::migrateDB) {
			$error = customInstallScript::migrateDB(\%properties);
		} else {
			$error = &migrateDB(\%properties);
		}	
		if ($error != 0) {
			return $error;
		}			
	}
	
	$error = &redeployEar();	
	if ($error != 0) {
		return $error;
	}

	if (defined &customInstallScript::postUpgrade) {
		$error = customInstallScript::postUpgrade(\%properties);
		if ($error != 0) {
			return $error;
		}
	}

	return $error;
}

# Install app's rpm (fresh install).
sub installRpm {
	my $path = shift;
    NmaUtil::ilog( "installScript: installing rpm");
    # change to "rpm -vi" or "rpm -vvi" for extra verbosity
	my $error = NmaUtil::execAndLog3("rpm -i $path"."/*.rpm", ">>$outLog", "2>>$errLog");
	if ($error == 256) {
		NmaUtil::ilog("installScript: Rpm JSSwagDTU is already installed. Will upgrade rpm, instead.");
		return &upgradeRpm($path);
	} elsif ($error != 0) {
		NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: install rpm JSSwagDTU failed.");
	} else {
		NmaUtil::ilog("installScript: add rpm complete");
	}
	return $error;
}

# Upgrade app's rpm on re-deploy, upgrade or patch.
sub upgradeRpm {
	my $path = shift;
    # change to "rpm -Uvh" or "rpm -Uvvh" for extra verbosity
	my $error = NmaUtil::execAndLog3 ("rpm -Uh --allfiles --force --nopreun $path"."/*.rpm", ">>$outLog", "2>>$errLog");
	if ($error == 0 || $error == 256) {
        NmaUtil::ilog("installScript: upgrade rpm complete");	
        return 0;	
	} else {
	    NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: upgrade rpm JSSwagDTU failed.");	
    }
    return $error;
    
}

# Create app's own db and configure XA datasource in domain.xml file. This subroutine can be overriden in the custom install script.
sub createDB {
    my $params = shift;
    my %properties = %$params;

	my $database = $properties{"DATABASE"} || $properties{"APPNAME"};
	my $dbName = $database."_db";

	my $error = 0;
	if ($database ne 'null') {
		NmaUtil::ilog("Creating database: ".$dbName);	
		
		NmaDb::createDb($database);
		$error = &createDataSource(\%properties);
	}
	return $error;
}

# Configure app logging.  App log file is located in /var/log/jboss/servers/server1/SwagDTU.log. This subroutine can be overriden in the custom install script.
sub addLog {
    my $params = shift;
    my %properties = %$params;
    my $logLevel = $properties{"LOG_LEVEL"} || "ALL";
    
	NmaUtil::ilog("Starting log configuration creation");
	my $cliInstruction = "/profile=full-ha/subsystem=logging/size-rotating-file-handler=SwagDTU:add(autoflush=true,level=$logLevel,rotate-size=50m,max-backup-index=15,append=true,file={\"relative-to\"=>\"jboss.server.log.dir\",\"path\"=>\"SwagDTU.log\"},formatter=\"%d{yyy-MM-dd HH:mm::ss, SSS} %-5p [%c] (%t) %s%E%n\")";
	my ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");	
	if ($error == 256) {
		NmaUtil::ilog("Log configuration already exists for SwagDTU");
	} elsif ($error != 0) {
		NmaUtil::ilog("Creation of log configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=logging/logger=vnd.jssdk.swagdtu:add(level=$logLevel,handlers=\[\"SwagDTU\"\])";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");    
    if ($error == 256) {
		NmaUtil::ilog("Logger configuration already exists for SwagDTU");
		return 0;
	} elsif ($error != 0) {
    	NmaUtil::ilog("Creation of logger configuration failed with error: $error:$stderr");
    } else {
    	NmaUtil::ilog("Creation of logger configuration successfully finished");
    }
    
    return $error;
}

# Configure app's own infinispan cache.  This subroutine can be overriden in the custom install script.
sub addInfinispan {
    my $params = shift;
    my %properties = %$params;
    
    my $installCache = $properties{"INSTALL_CACHE"} || "false";   
    if ($installCache ne 'true') {
    	return 0;
   	}
    
	NmaUtil::ilog("Starting infinispan configuration creation");
	my $cliInstruction = "/profile=full-ha/subsystem=infinispan/cache-container=SwagDTU/:add(aliases=[\"SwagDTU\"],default-cache=SwagDTUCache)";
	my ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
	if ($error == 256) {
		NmaUtil::ilog("Infinispan configuration already exists for SwagDTU");
		return 0;
	} elsif ($error != 0) {
		NmaUtil::ilog("Creation of infinispan configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=infinispan/cache-container=SwagDTU/transport=TRANSPORT/:add(lock-timeout=60000)";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    if ($error != 0) {
		NmaUtil::ilog("Creation of infinispan configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=infinispan/cache-container=SwagDTU/replicated-cache=SwagDTUCache:add(batching=true,mode=SYNC)";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    if ($error != 0) {
		NmaUtil::ilog("Creation of infinispan configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=infinispan/cache-container=SwagDTU/replicated-cache=SwagDTUCache/locking=LOCKING/:add(isolation=READ_COMMITTED)";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    if ($error != 0) {
		NmaUtil::ilog("Creation of infinispan configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=infinispan/cache-container=SwagDTU/replicated-cache=SwagDTUCache/file-store=FILE_STORE:add(shared=false,preload=true,passivation=false,fetch-state=true,purge=false,relative-to=\"SwagDTUCacheDir\")";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    if ($error != 0) {
		NmaUtil::ilog("Creation of infinispan configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=infinispan/cache-container=SwagDTU/replicated-cache=SwagDTUCache:write-attribute(name=start,value=EAGER)";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    if ($error != 0) {
		NmaUtil::ilog("Creation of infinispan configuration failed with error: $error:$stderr");
		return $error;
    }
    
    NmaUtil::ilog("Creation of infinispan configuration successfully finished");
    return 0;
}


# Deploy app's ear file on fresh install.
sub deployEar {
	my $url = "cgi-bin/deployApp";
    my $param = "servergroup=$serverGroup&path=/usr/local/jboss/standalone/deployments&earName=SwagDTU.ear&";
    my $error = NmaUtil::callNma($url, $param, "127.0.0.1");  
	if ($error =~ /^\d+?$/ && ($error == 0 || $error == 256)) {
        NmaUtil::ilog("installScript: deploy ear completed successfully");	
        return 0;	
	} elsif ($error =~ m/SUCCESS/) {
		NmaUtil::ilog("installScript: deploy ear completed successfully");	
        return 0;
	}
	else {
	    NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: Deploy ear failed with error: $error");	
    }        
    return $error;  
}

# Redeploy app's ear on SDK re-deploy, upgrade or patch.
sub redeployEar {
    my $error = NmaUtil::forceRedeployApp("SwagDTU.ear");
	if ($error == 0 || $error == 256) {
        NmaUtil::ilog("installScript: redeploy ear completed successfully");	
        return 0;	
	} else {
	    NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: Redeploy ear failed with error: $error");	
    }
    return $error;
}

# Run app's custom migration script on upgrade or patch only. This subroutine can be overriden in the custom install script.
sub migrateDB {
    my $params = shift;
    my %properties = %$params;
    
	my $dsName = $properties{"DATABASE"} || 'SwagDTU';
	my $error = 0;
	if ($dsName ne 'null') {
	    my $path = $properties{"path"};
	    my $migratedb = "/var/www/cgi-bin/migrateDB_JSSwagDTU.sql";
	    unless (-e $migratedb) {
	        NmaUtil::ilog("installScript: file $migratedb is not present; will not migrate database");
	        return 1;
	    }
	    NmaUtil::ilog("installScript: migrating database $dbName");
	    
	    my $dbuser = NmaDb::getDbUser();
	    my $dbpass = NmaDb::getDbPass();
	    my $dbhost = NmaDb::getDbIp();
	    
	    my $command = "/usr/bin/mysql --verbose -h $dbhost -u $dbuser --password=$dbpass --database=$dbName < $migratedb";
	    my $error = NmaUtil::execAndLog3($command, ">>$outLog", "2>>$errLog");
	    if ($error != 0) {
	    	my $errorMsg = "ERROR: migrate database $dbName failed with error: $error:$stderr";
	        NmaUtil::ilog($errorMsg);
	        NmaUpgradeUtil::passInstallStatusInfo($error, $errorMsg);
	        return $error;
        } else {	    	        
	        NmaUtil::ilog("Migration of database $dbName completed successfully.");	        
	    }
    }
    return $error;
}

#adds data source
sub createDataSource {

	my $params = shift;
    my %properties = %$params;
	my $dataSourceSecDomain = $properties{"INSTALL_DATASOURCE_SECURITY_DOMAIN"} || "false";   
    if ($dataSourceSecDomain ne 'true') {
    	return createDataSourceWithPassword(\%properties);
   	} else {
   		return createDataSourceWithSecurityDomain(\%properties);
   	}
}

#create data source for this app using cleartext username/password authentication (default)
sub createDataSourceWithPassword {

	my $params = shift;
    my %properties = %$params;
    
	my $dbName = $properties{"DATABASE"} || 'SwagDTU';
	$dbName = $dbName."_db";
    my $dsName = $properties{"DATASOURCE"}; 

    my $error = NmaUtil::execAndLog3("/bin/sh /usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '/profile=full-ha/subsystem=datasources/data-source=$dsName"."/:add(jndi-name=java:jboss/datasources/$dsName".",driver-name=com.mysql,connection-url=jdbc:mysql://localhost:3306/$dbName".",max-pool-size=20,track-statements=NOWARN,flush-strategy=FailingConnectionOnly,min-pool-size=0,user-name=root,password=netscreen) '", ">/dev/null", "2>>/var/log/install.log");
    if ($error == 256) {
    	NmaUtil::ilog("Datasource configuration already exists for SwagDTU");
    } elsif ($error != 0) {
        NmaUtil::ilog("Creation of datasource failed with error: $error");
        return $error;
    }

    $error = NmaUtil::execAndLog3("/bin/sh /usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '/profile=full-ha/subsystem=datasources/data-source=$dsName"."/:enable '", ">/dev/null", "2>>/var/log/install.log");
    if ($error == 256) {
    	NmaUtil::ilog("Data source configuration is already enabled for SwagDTU");
    	return 0;
    } elsif ($error != 0) {
        NmaUtil::ilog("Could not enable datasource. Error: $error");
    }
    return $error;

}

#create data source for this app using security domain authentication
sub createDataSourceWithSecurityDomain {

	my $params = shift;
    my %properties = %$params;

	my $dbName = $properties{"DATABASE"} || $properties{"APPNAME"};
	$dbName = $dbName."_db";
	my $dsName = $properties{"DATASOURCE"}; 

	
	NmaUtil::ilog("Starting datasource creation");

	my $cliInstruction = "/profile=full-ha/subsystem=security/security-domain=".$dsName."EncryptedPassword:add(cache-type=\"default\")";
	my ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");

	if ($error == 256) {
		NmaUtil::ilog("security-domain configuration already exists for SwagDTU");
	} elsif ($error != 0) {
		NmaUtil::ilog("Creation of security-domain configuration failed with error: $error:$stderr");
		return $error;
    }

    $cliInstruction = "/profile=full-ha/subsystem=security/security-domain=".$dsName."EncryptedPassword/authentication=classic:add()";
 	($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");

	if ($error == 256) {
		NmaUtil::ilog("security-domain configuration already exists for SwagDTU");
	} elsif ($error != 0) {
		NmaUtil::ilog("Creation of security-domain configuration failed with error: $error:$stderr");
		return $error;
    }   

	$cliInstruction = "/profile=full-ha/subsystem=security/security-domain=".$dsName."EncryptedPassword/authentication=classic/login-module=org.picketbox.datasource.security.SecureIdentityLoginModule:add(code=\"org.picketbox.datasource.security.SecureIdentityLoginModule\",flag=\"required\",module-options=[(\"username\"=>\"jboss\"),(\"password\"=>\"-6896c21a0b4ec4742ecb34b08c0e0e03\"),(\"managedConnectionFactoryName\"=>\"jboss.jca:service=XATxCM,name=".$dsName."\")])";
	($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");

	if ($error == 256) {
		NmaUtil::ilog("security-domain configuration already exists for SwagDTU");
	} elsif ($error != 0) {
		NmaUtil::ilog("Creation of security-domain configuration failed with error: $error:$stderr");
		return $error;
    }   

	$cliInstruction = "/profile=full-ha/subsystem=datasources/xa-data-source=$dsName:add(use-java-context=true,use-ccm=false,driver-name=com.mysql,transaction-isolation=TRANSACTION_READ_COMMITTED,min-pool-size=15,max-pool-size=150,pool-prefill=true,flush-strategy=EntirePool,security-domain=".$dsName."EncryptedPassword,valid-connection-checker-class-name=\"org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker\",stale-connection-checker-class-name=\"org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker\",exception-sorter-class-name=\"org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter\",set-tx-query-timeout=true,blocking-timeout-wait-millis=5000,idle-timeout-minutes=1,query-timeout=300,prepared-statements-cache-size=100,share-prepared-statements=true,jndi-name=\"java:jboss/datasources/$dsName\")";
	($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");

	if ($error == 256) {
		NmaUtil::ilog("datasource configuration already exists for SwagDTU");
		return 0;
	} elsif ($error != 0) {
		NmaUtil::ilog("Creation of datasource configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=datasources/xa-data-source=$dsName/xa-datasource-properties=DatabaseName:add(value=$dbName)";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    
    if ($error != 0) {
		NmaUtil::ilog("Creation of datasource configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=datasources/xa-data-source=$dsName/xa-datasource-properties=ServerName:add(value=jmp-CLUSTER)";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    
    if ($error != 0) {
		NmaUtil::ilog("Creation of datasource configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=datasources/xa-data-source=$dsName/xa-datasource-properties=AutoReconnectForPools:add(value=true)";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    
    if ($error != 0) {
		NmaUtil::ilog("Creation of datasource configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=datasources/xa-data-source=$dsName/xa-datasource-properties=AutoReconnect:add(value=true)";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    
    if ($error != 0) {
		NmaUtil::ilog("Creation of datasource configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=datasources/xa-data-source=$dsName:enable";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
    
    if ($error != 0) {
		NmaUtil::ilog("Creation of datasource configuration failed with error: $error:$stderr");
		return $error;
    }
    
    NmaUtil::ilog("Creation of datasource configuration successfully finished");
    return 0;
}
