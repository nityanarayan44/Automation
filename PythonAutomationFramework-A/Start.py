#############################
# Automation Framework		#
# @Author: Ashutosh Mishra	#
# @Init: 17April2017		#
# Python-Selenium-Behave	#
#############################

#InBuilt Import Section.
import os
import time
import subprocess
from selenium import webdriver
from behave import *
#################################################################################

#Local Import[Mine Wrote Python Classes]
from Core.Basic.FrameworkDriver import FrameworkDriver
from Src import *
from Src.Utils.Printer import Printer as Printer
from Src.steps import Steps as Steps
#################################################################################

#################################################################################
#	Framework Object Setup
#################################################################################
#Setting Up Logger Object to log.
log = Logger()

#Printer().printInitiation()
#
# x = FrameworkDriver()
# driver = x.getChromeDriver()
#
# y = FrameworkUtil()
# driver = y.navigate(driver, 'https://www.google.com')
#
# x.closeWebDriverObject(driver)

#logging a text statement
log.write("This is a farji LOG")

#Running BEHAVE
print 'Running Behave Now.....'
subprocess.call(["behave"])

log.write("This is last line of the framework.")
#################################################################################
#	Framework End Point															#
#################################################################################
