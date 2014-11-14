package customUninstallScript;

# Custom Uninstall Script
#
# Use this perl library script to define custom behavior during app un-installation workflow.
# The workflow order is defined by uninstallScript.pl in the parent folder and can't be changed.
# However, you can change or add your own custom behavior at certain steps of the workflow,
# by uncommenting and adding logic to the subroutines in this script.
#
# The workflow for addApp (fresh install):
#
#		&preUninstall()				define in customUninstallScript
#		&undeployApp()
#		&cleanupEarContent()		override in customUninstallScript
#		&removeLog()				override in customUninstallScript			
#		&removeInfinispan()			override in customUninstallScript
#		&removeDatabase()			override in customUninstallScript
#		&uninstallRpm()
#		&runCustomCleanup()			override in customUninstallScript
#		&postUninstall()			define in customUninstallScript
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
# Custom behavior to be executed before app is uninstalled.
#sub preUninstall {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Misc cleanup of ear content
#sub cleanupEarContent() {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Removes app logging from domain.xml file
#sub removeLog {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Removes app's infinispan container
#sub removeInfinispan {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Create app's own db and configure XA datasource in domain.xml file.
#sub removeDatabase {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}
#
# Runs custom cleanup shell script (defined by the app developer)
#sub runCustomCleanup {
#    my $params = shift;
#	 return 0;
#}
#
# Custom behavior to be executed after app is uninstalled.
#sub postUninstall {
#    my $params = shift;
#    my %properties = %$params;
#	 return 0;
#}

1;
