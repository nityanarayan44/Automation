#InBuilt Import.
import datetime

#Class Definition
class Logger:

    # Constructor {__init__(self)}
    def start(self):
        dashes = '##########################################################################'
    	print(  dashes + "\n\t Initiating Logging........\n" + dashes)
    	print( "Starting [System Time]:: " + str(datetime.datetime.now().time()) )
    	print( "Starting [System Date]:: " + str(datetime.datetime.now().date()) )
    	print( "\n" + dashes)

    # Log out Method
    def write(self, logs):
        print ('['+str(datetime.datetime.now().date())+', '+str(datetime.datetime.now().time())+'] ' + logs)
