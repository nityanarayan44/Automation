#Framework's Util functions
class FrameworkUtil:

	#Logger
	def log(self, line):
		print ">>> " + line

	#navigate for given url.
	def navigate(self, driver, url):
		FrameworkUtil().log('Navigating '+url+'....\n')
		driver.get(url)
		return driver

	#navigate for given url.
	def getTitle(self, driver, url):
		FrameworkUtil().log('Fetching title of '+url+'....\n')
		return driver.title
