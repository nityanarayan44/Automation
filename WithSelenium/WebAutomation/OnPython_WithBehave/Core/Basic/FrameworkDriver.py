#Import Section
from selenium import webdriver

#Framework's Basic Function regarding WebDrivers.
class FrameworkDriver:

	#Standard Variables [ In Case (if any) ]
	path = "C:\DRIVERS\chromedriver_win32\chromedriver.exe"
	chromeDriverPath = 'C:\DRIVERS\chromedriver_win32\chromedriver.exe'
	firefoxDriverPath = 'C:\DRIVERS\geckodriver_win64\geckodriver.exe'
	
	
	#Getting chrome/firefox/etc driver with the params
	def getDriver(self, browser):
		
		#According the browser parameter, setting the WebDriver.
		if(browser == 'CHROME'):
			#Do for Chrome
			driver = webdriver.Chrome(self.chromeDriverPath)
			
		elif(browser == 'FIREFOX'):
			#Do for Firefox
			driver = webdriver.Firefox(self.firefoxDriverPath)
			
		elif(browser == 'SAFARI'):
			#Do for Safari
			driver = webdriver.Chrome(self.path)
			
		else:
			#Just Default set Chrome
			driver = webdriver.Chrome(self.path)
				
		#Returning web driver now
		return driver
		

	def closeWebDriverObject(self, driver):
		#FrameworkUtil().log('Closing Given Web Driver....\n')
		driver.close()
		
	def terminateFramework(self):
		#FrameworkUtil().log('Terminating FRAMEWORK....\n')
		exit()
		