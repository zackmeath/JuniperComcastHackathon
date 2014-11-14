#!/usr/bin/perl
# Copyright (c) 2014 Juniper Networks. All rights reserved.
# Auto generated script. Please do not modify this file.  You can add custom changes in customUninstallScript.pl.
#
# This uninstallScript.pl is executed during application's un-deployment.  
# The purpose of this script is to perform app-specific operations during
# the un-deployment life-cycle.
# The app packager extracts this script from the application's image
# and copies it to /var/www/cgi-bin/uninstall_SwagDTU.pl file where the uninstall script finds it.
#
# This script is called without parameters.
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
use lib ("/var/www/cgi-bin/custom_SwagDTU");
use customUninstallScript;


$ENV{"PATH"}="/bin:/sbin:/usr/bin:/usr/sbin";
$<=$>;
$| = 1;  my $error = 0;
my $status = "SUCCESS";

# Define stdout and stderr log files
my $outLog = '/var/log/install.log';
my $errLog = '/var/log/install.log';

my $q= new CGI;
print $q->header({-type=>'text/plain'});
print "<response>\n";
print "\t<message>\n";
print "<![CDATA[\n";

$error = &uninstall();

print  "]]>\n";
print  "\t</message>\n";
if ($error != 0) {
        $status = "FAILURE";
        print "\t<errorcode>$error</errorcode>";
}
print  "\t<status>$status</status>\n</response>\n";


# Subroutine Section:


my %properties;

# main subroutine for uninstall
sub uninstall {
    my $error = 0;
    my $errorCnt = 0;

    NmaUtil::ilog("Undeploying SwagDTU");
    
    &readProps();
    
	if (defined &customUninstallScript::preUninstall) {
		$error = customIntallScript::preUninstall(\%properties);
		if ($error != 0) {
			return $error;
		}
	}    
	
    $error = &undeployApp();
    if ($error != 0 && $error != 256) {
		$errorCnt++;
    }  
    
 	if (defined &customUninstallScript::cleanupEarContent) {
		$error = customUninstallScript::cleanupEarContent(\%properties);
	} else {
		$error = &cleanupEarContent(\%properties);
	}		   
    if ($error != 0 && $error != 256) {
		$errorCnt++;
    }   
    
 	if (defined &customUninstallScript::removeLog) {
		$error = customUninstallScript::removeLog(\%properties);
	} else {
		$error = &removeLog(\%properties);
	}	        
    if ($error != 0 && $error != 256) {
		$errorCnt++;
    }

 	if (defined &customUninstallScript::removeInfinispan) {
		$error = customUninstallScript::removeInfinispan(\%properties);
	} else {
		$error = &removeInfinispan(\%properties);
	}	    
    if ($error != 0 && $error != 256) {
		$errorCnt++;
    }     

 	if (defined &customUninstallScript::removeDatabase) {
		$error = customUninstallScript::removeDatabase(\%properties);
	} else {
		$error = &removeDatabase(\%properties);
	}	
    if ($error != 0 && $error != 256) {
		$errorCnt++;
    } 	
    
    $error = &uninstallRpm();
    if ($error != 0 && $error != 256) {
		$errorCnt++;
    }   

 	if (defined &customUninstallScript::runCustomCleanup) {
		$error = customUninstallScript::runCustomCleanup(\%properties);
	} else {
		$error = &runCustomCleanup(\%properties);
	}	
    if ($error != 0 && $error != 256) {
		$errorCnt++;
    }   

	if (defined &customUninstallScript::postUninstall) {
		$error = customIntallScript::postUninstall(\%properties);
		if ($error != 0) {
			return $error;
		}
	}    
	        
	if ($errorCnt > 0) {
		NmaUtil::ilog("$errorCnt error(s) found while un-installing SwagDTU");
		return 1;
	} else {
    	NmaUtil::ilog("Un-install of SwagDTU completed successfully");
    	return 0;
    }
}

# Read script.properties file and initialize properties hash
sub readProps() {
	# Initialize static properties
	%properties = (
		vendor => 'jssdk',
		appName => 'SwagDTU'
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

# Undeploys app's ear file
sub undeployApp {  
    my $url = "cgi-bin/undeployApp";
    my $param = "earName=SwagDTU.ear&";
    my $error = NmaUtil::callNma($url, $param, "127.0.0.1");
    if ($error != 0 && $error != 256) {
 		NmaUtil::ilog("ERROR: Undeployment of application SwagDTU failed with status: $error");
		NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: Undeployment of application SwagDTU failed");
		return $error;
    }  
    NmaUtil::ilog("Undeployment of application SwagDTU succeeded");
    return 0;    	
}

# Removes app logging from domain.xml file
sub removeLog {
    my $params = shift;
    my %properties = %$params;
    
	NmaUtil::ilog("Starting log configuration removal");
	my $cliInstruction = "/profile=full-ha/subsystem=logging/size-rotating-file-handler=SwagDTU:remove";
	my ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
	if ($error != 0) {
		NmaUtil::ilog("Removal of log configuration failed with error: $error:$stderr");
		NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: Removal of log configuration failed with error: $error:$stderr");
		return $error;
    }
    
    $cliInstruction = "/profile=full-ha/subsystem=logging/logger=vnd.jssdk.swagdtu:remove";
    ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");    
    if ($error != 0) {
    	NmaUtil::ilog("Removal of log configuration failed with error: $error:$stderr");
    	NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: Removal of log configuration failed with error: $error:$stderr");
    } else {
    	NmaUtil::ilog("Removal of log configuration successfully finished");
    }
    
    return $error;
}

# Removes app's infinispan container
sub removeInfinispan {
    my $params = shift;
    my %properties = %$params;
    
    my $installCache = $properties{"INSTALL_CACHE"} || "false";   
    if ($installCache ne 'true') {
    	return 0;
   	}   
   	 
	NmaUtil::ilog("Starting infinispan configuration removal");
	my $cliInstruction = "/profile=full-ha/subsystem=infinispan/cache-container=SwagDTU:remove";
	my ($error, $stdout, $stderr) = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
	if ($error != 0 && $error != 256) {
		NmaUtil::ilog("Removal of infinispan configuration failed with error: $error:$stderr");
		NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: Removal of infinispan configuration failed with error: $error:$stderr");
		return $error;
    }
    
    NmaUtil::ilog("Removal of infinispan configuration successfully finished");
    return 0;
}

# uninstall app's rpm
sub uninstallRpm() {
   	NmaUtil::ilog("Removing rpm: JSSwagDTU");
    my $error = NmaUtil::execAndLog3("/bin/rpm -ev JSSwagDTU", ">>$outLog", "2>>$errLog");
    if ($error != 0 && $error != 256) {
    	NmaUtil::ilog("ERROR: rpm uninstallation of app failed with status: $error");
		NmaUpgradeUtil::passInstallStatusInfo($error, "ERROR: rpm uinstallation of app failed with status: $error");
		return $error;
    }  
    NmaUtil::ilog("Uninstall of JSSwagDTU rpm succeeded");
    return 0;     
}    

# Removes app database and data source
sub removeDatabase {
    my $params = shift;
    my %properties = %$params;
    
	my $database = $properties{"DATABASE"} || $properties{"APPNAME"};
	my $dbName = $database."_db";
	
	if ($database ne "null") {
	    NmaUtil::ilog("Dropping database $dbName");
	    #$error = NmaDb::removeAppDsSDK($dsName);
	    NmaDb::dropDb($database);
	    $error = &removeDataSource(\%properties);
		return $error;
	} 
	return 0;
}

# Runs custom cleanup shell script (defined by the app developer)
sub runCustomCleanup {
    my $params = shift;
    my %properties = %$params;
    
	my $error = 0;
	my $script = "/var/www/cgi-bin/Cleanup_JSSwagDTU.sh";
	
	unless (-e $script) {
        NmaUtil::ilog("File $script is not present; will not run custom cleanup script");
        return 0;
    }
    
    NmaUtil::ilog("Running custom cleanup for SwagDTU");    
    my ($error, $stdout, $stderr) = NmaUtil::execAndLog2($script);
    if ($error == 0) {
    	NmaUtil::ilog("Custom cleanup script ran successfully.");
    } else {
    	my $errorMsg = "ERROR: custom cleanup script failed with error: $error:$stderr";
        NmaUtil::ilog($errorMsg);
        NmaUpgradeUtil::passInstallStatusInfo($error, $errorMsg);
    }
    NmaUtil::ilog("Custom Cleanup for SwagDTU succeeded");
	return $error;	   
}

# Misc cleanup of ear content
sub cleanupEarContent() {
    my $params = shift;
    my %properties = %$params;
    
    NmaUtil::ilog("Cleaning up ear content for SwagDTU");
    NmaUtil::cleanUpEarContentsOnUninstall("SwagDTU");
    NmaUtil::ilog("Cleanup ear content for SwagDTU finished");
    return 0;  
    
}
#Removes data source
sub removeDataSource {
	my $params = shift;
    my %properties = %$params;

	my $dsName = $properties{"DATASOURCE"};	
	my $dataSourceSecDomain = $properties{"INSTALL_DATASOURCE_SECURITY_DOMAIN"} || "false";   

	NmaUtil::ilog("Starting datasource configuration removal");
    if ($dataSourceSecDomain eq 'true') {
		my $cliInstruction = "/profile=full-ha/subsystem=security/security-domain=".$dsName."EncryptedPassword:remove";
		my ($error, $stdout, $stderr)  = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
		if ($error != 0) {
			NmaUtil::ilog("Removal of security-domain configuration failed with error: $error:$stderr");
			return $error;
	    }
	}
	if ($dataSourceSecDomain eq 'true') {
		$cliInstruction = "/profile=full-ha/subsystem=datasources/xa-data-source=$dsName:remove";
	} else {
		$cliInstruction = "/profile=full-ha/subsystem=datasources/data-source=$dsName:remove";
	}
	($error, $stdout, $stderr)  = NmaUtil::execAndLog2("/usr/local/jboss/bin/jboss-cli.sh --connect --controller=jmp-CLUSTER --user=admin --password=juniper_123 '$cliInstruction'");
	if ($error != 0) {
		NmaUtil::ilog("Removal of datasource configuration failed with error: $error:$stderr");
		return $error;
    }
    
    NmaUtil::ilog("Removal of datasource configuration successfully finished");
    return 0;
}