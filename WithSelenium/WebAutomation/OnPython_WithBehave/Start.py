#############################
# Automation Framework		#
# @Author: Ashutosh Mishra	#
# @github: nityanarayan44   #
# @Init: 17April2017		#
# @Project: Web Automation  #
# Python-Selenium-Behave	#
#############################

#========================
#InBuilt Import Section.
#========================
import os
import time
import subprocess
from selenium import webdriver
from behave import *


#===========================================
#Local Import[Mine Wrote Python Classes]
#===========================================
from Core.Basic.FrameworkDriver import FrameworkDriver
#from Src import *
#from Src.Utils.Printer import Printer as Printer
from Src.Utils.Logger import Logger as Logger

#===========================================
#	Framework Object Setup
#===========================================
    # Sample Codes
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
    #log.write("This is a farji LOG")

#===========================================
# Running BEHAVE
#===========================================
Logger().write("Running Behave Now.....")
subprocess.call(["behave"])
Logger().write("Framework execution completed.")

#################################################################################
#	Framework End Point															#
#################################################################################
