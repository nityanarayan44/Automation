#Importing Behave
from behave import *

#Class Definitions...
class Steps:
    @given('some known state')
    def step_impl(context):
        #print("Implemented The Given Keyword")
        a = 1

    @then('some observed outcome')
    def step_impl(context):
        #print("Implemented The Then Keyword.")
        b = 1

    @given('some data')
    def step_impl(context):
        #print("Implemented The Given Keyword")
        a = 1

    @then('i will perform something')
    def step_impl(context):
        #print("Implemented The Then Keyword.")
        b = 1
