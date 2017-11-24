#InBuilt Import.
import datetime

#Class Definition
class Printer:
    #A Simple Function for printing Data and Time at time of Framework Initiatation.
    def printInitiation(self):
    	dashes = '##########################################################################'
    	print(  dashes + "\n\t Initiating FRAMEWORK........\n" + dashes)
    	print( "Starting [System Time]:: " + str(datetime.datetime.now().time()) )
    	print( "Starting [System Date]:: " + str(datetime.datetime.now().date()) )
    	print( "\n" + dashes)
