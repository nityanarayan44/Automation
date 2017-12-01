#===========================================
# FILE:Features/environment.py
#===========================================

#===========================================
# Import Section.
#===========================================
from Utils.Logger import Logger
from behave.log_capture import capture

@capture
def before_all(context):
    Logger().write("Starting Framework >>>>>>>>>>>>>>")
    #print("Starting Framework.....")
	#wd = obj.getDriver('CHROME')
	#wd.get('http://ww.google.co.in')
	#time.sleep(5)
	#Closing Drivers.
	#print 'Closing WebDriver...'
	#obj.closeWebDriverObject(wd)

@capture
def before_scenario(self, context):
    Logger().write("Starting Scenario.....")

@capture
def before_feature(self, context):
    Logger().write("Starting Feature.....")

@capture
def after_scenario(self, context):
    Logger().write("Ending Scenario.....")

@capture
def after_feature(self, context):
    Logger().write("Ending Feature.....")

@capture
def after_all(context):
    #TODO: Copy and rename the created output of JSON Format.
	print ("\n\n\n")
	print ("+----------------------------------------------------------+")
	print ("| Framework Executed all requested Feature File            |")
	print ("+----------------------------------------------------------+")
