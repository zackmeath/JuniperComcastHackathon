#!/bin/sh

# This script is a place-holder where you can specify custom clean up action that you want to carry out
# when you uninstall your application
# Junos Space Platform will automatically invoke this script during SwagDTU uninstall operation

perl -e 'use lib("/usr/nma/lib"); use NmaUtil; print NmaUtil::ilog("Custom clean up called for SwagDTU.");'

exit 0
