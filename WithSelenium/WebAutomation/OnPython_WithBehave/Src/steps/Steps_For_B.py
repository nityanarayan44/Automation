# file:features/steps/Steps_For_A.py
# ----------------------------------------------------------------------------
# STEPS:
# ----------------------------------------------------------------------------
from behave   import given, when, then

#Class Definitions...
class Steps_For_B:
    # Global Object (if any)..

    @given('there is a "{thing}"')
    def step_given_assert_thing(context, thing):
        if "apple" == thing:
            print('thing matched.')

    @then('it should also match with "{other_thing}"')
    def step_then_should_match_with(context, other_thing):
        if "apple" == other_thing:
            print('other_thing matched.')
