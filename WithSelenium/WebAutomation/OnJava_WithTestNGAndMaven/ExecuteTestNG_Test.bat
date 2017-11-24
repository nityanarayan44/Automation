color 1e
title NNG:Test_Automation
@echo off
set projectLocation=E:\MY-WORKPLACE\__GIT_PROJECTS\Java_Projects\Automation\WithSelenium\WebAutomation\OnJava_WithTestNGAndMaven
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause