%define cgidir /var/www/cgi-bin
%define jboss_deploy /usr/local/jboss/standalone/deployments
%define version 1
%define earName ${APPNAME}
Name: JS${APPNAME}
Summary: ${SUMMARY}
Epoch: 0
Version: ${VERSION}
Release: %{jmp_cl_num}
License: ${LICENSE}
Group: ${GROUP}
BuildRoot:  %{_tmppath}/%{name}-%{version}

%define spaceconfdir %{spaceconfroot}/%{name}

%description
%Junos Space Application RPM Package

%prep
%setup -c -T

%build
find %{ear_location}../../bin/%{earName} -name urls.xml -exec cp '{}' . \;
find %{ear_location}../../bin/%{earName} -name sockets.xml -exec cp '{}' . \;

cd %{ear_location}../../bin/%{earName}
if [ -d custom_%{earName} ]; then
	tar cvfz custom_%{earName}.tgz custom_%{earName}
	rm -rf %{earName}/custom_%{earName}	
fi

%install
rm -rf $RPM_BUILD_ROOT
mkdir -p $RPM_BUILD_ROOT%{cgidir}
mkdir -p $RPM_BUILD_ROOT/%{jboss_deploy}/
mkdir -p $RPM_BUILD_ROOT/cgi-bin
mkdir -p $RPM_BUILD_ROOT%{spaceconfdir}


cp %{ear_location}/%{ear_file_name} $RPM_BUILD_ROOT/%{jboss_deploy}/

cp -f %{ear_location}../../bin/%{earName}/urls.xml $RPM_BUILD_ROOT%{spaceconfdir}
cp -f %{ear_location}../../bin/%{earName}/sockets.xml $RPM_BUILD_ROOT%{spaceconfdir}
cp %{ear_location}../../bin/%{earName}/Cleanup_%{name}.sh  $RPM_BUILD_ROOT/%{cgidir}/Cleanup_%{name}.sh
cp %{ear_location}../../bin/%{earName}/migrateDB.sql $RPM_BUILD_ROOT/%{cgidir}/migrateDB_%{name}.sql
cp %{ear_location}../../bin/%{earName}/uninstallScript.pl $RPM_BUILD_ROOT/%{cgidir}/uninstall_%{earName}.pl
cp %{ear_location}../../bin/%{earName}/spec.properties $RPM_BUILD_ROOT/%{cgidir}/spec_%{earName}.properties

# untar tgz file containing custom scripts and copy folder to /var/www/cgi-bin
cd %{ear_location}../../bin/%{earName}
tar xvfz custom_%{earName}.tgz 
cp -R custom_%{earName} $RPM_BUILD_ROOT/%{cgidir}/
rm -f custom_%{earName}.tgz

%post

%preun

%files
%attr(755, jboss, jboss) /%{jboss_deploy}/%{ear_file_name}
%attr(755, apache, space)  /%{cgidir}/Cleanup_%{name}.sh
%attr(755, apache, space) /%{cgidir}/uninstall_%{earName}.pl
%attr(755, apache, space) /%{cgidir}/spec_%{earName}.properties
%attr(755, apache, space) /%{cgidir}/migrateDB_%{name}.sql
%attr(440, root, root) %{spaceconfdir}
%attr(755, apache, space) /%{cgidir}/custom_${APPNAME}
