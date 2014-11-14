package customInstallScript;

# Custom Install Script
#
# Use this perl library script to define custom behavior during app installation workflow.
# The workflow order is defined by installScript.pl in the parent folder and can't be changed.
# However, you can change or add your own custom behavior at certain steps of the workflow,
# by uncommenting and adding logic to the subroutines in this script.
#
# The workflow for addApp (fresh install):
#
#		&installRpm()	
#		&preInstall()				define in customInstallScript
#		&createDB()					override in customInstallScript
#		&addLog()					override in customInstallScript			
#		&addInfinispan()			override in customInstallScript
#		&deployEar()
#		&postInstall()				define in customInstallScript
#
# The workflow for upgradeApp and patchApp:
#
#		&upgradeRpm()	
#		&preUpgrade()				define in customInstallScript
#		&createDB()					override in customInstallScript
#		&addLog()					override in customInstallScript			
#		&addInfinispan()			override in customInstallScript
#		&migradeDB()				override in customInstallScript
#		&redeployEar()
#		&postUpgrade()				define in customInstallScript
#
# Each subroutine in the workflow takes a %properties hash parameter (passed by reference) 
# which has the following structure:
#
#		%properties = (
#			"DATABASE" => "${APPNAME}",
#			"DATASOURCE" => "${APPNAME}DS",
#			"RELEASE_DATE" => "8/23/2014",
#			"SUMMARY" => "Juniper Application",
#			"LICENSE" => "Commercial",
#			"LOG_LEVEL" => "DEBUG",
#			"INSTALL_DATASOURCE_SECURITY_DOMAIN" => "false",
#			"INSTALL_CACHE" => "false",
#			"action" => "add|upgrade|patch",
#			"appName" => "${APPNAME}",
#			"currentVersion" => "1.0",
#			"newVersion" => "1.1",
#			"path" => "/var/cache/jboss/jmp/payloads/${APPNAME}-1.0-99.99",
#			"platformVersion" => "14.1",
#			"release" => "R1",
#			"serverGroup" => "platform",
#			"vendor" => "${VENDOR}" 
#		);
#
# Custom behavior to be executed before new app is installed.
#sub preInstall {
#    my $params = shift;
#    my %properties = %$params;
#}
#
# Custom behavior to be executed after new app is installed.
#sub postInstall {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Custom behavior to be executed before an already installed app is upgraded or patched.
#sub preUpgrade {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Custom behavior to be executed after an already installed app is upgraded or patched.
#sub postUpgrade {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Create app's own db and configure XA datasource in domain.xml file.
#sub createDB {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Configure app logging.  App log file is located in /var/log/jboss/servers/server1/WorldCities.log. 
#sub addLog {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Configure app's own infinispan cache. 
#sub addInfinispan {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Run app's custom migration script on upgrade or patch only. This subroutine can be overriden in the custom install script.
#sub migrateDB {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}

1;
