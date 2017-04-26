# -- FILE:Features/environment.py
from behave.log_capture import capture

@capture
def before_all(context):
    print("Starting Framework.....")

@capture
def before_scenario(self, context):
    print("Starting Scenario.....")

@capture
def before_feature(self, context):
    print("Starting Feature.....")

@capture
def after_scenario(self, context):
    print("Ending Scenario.....")

@capture
def after_feature(self, context):
    print("Ending Feature.....")

@capture
def after_all(context):
    #Copy and rename the created output of JSON Format.
    print("After all.....")
