# sb-upgrade-62-sdk
This is the source sdk with the 6.2 service builder portlet and dependent portlet that will be upgraded to 7 CE / DXP.

It contains two portlets, the first is the school-portlet which contains the service builder portlet code.

The second is the course list portlet which just uses the service to display the course list.  Nothing fancy, but it does have
a dependency on the school service so we'll be able to check what happens when we move to Liferay 7 CE / Liferay DXP.
