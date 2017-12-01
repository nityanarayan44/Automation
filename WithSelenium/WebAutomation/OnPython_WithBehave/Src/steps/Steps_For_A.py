#Importing Behave
from behave import *

#Class Definitions...
class Steps_For_A:
    @given('There is some data "{thing}"')
    def step_impl(context, thing):
        print("Implemented The Given Keyword on A")
        #a = 1

    @given('i will parse that data "{thing}"')
    def step_impl(context, thing):
        print("Implemented The Given Keyword on A.")
        #b = 1

    @then('i will perform something on that Data')
    def step_impl(context):
        print("Implemented The Then Keyword on A.")
