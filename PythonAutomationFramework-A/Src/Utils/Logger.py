#InBuilt Import.
import datetime

#Class Definition
class Logger:

    def write(self, logs):
        print ('['+str(datetime.datetime.now().date())+', '+str(datetime.datetime.now().time())+'] ' + logs)
