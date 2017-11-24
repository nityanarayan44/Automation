# SelPyBehave

[Required Modules]<br/>
This framework is developed in Python 2.7, so used and required modules are
- Selenium Webdriver
- behave

[Runnning the Framework]<br/>
just Run the Command in terminal "behave" under the path "./SelPyBehave/"<br/>


Since this is very basic prototype of Python+Behave+Selenium Automation Framework, <br/>
so just write a feature file under "./SelPyBehave/Src/Features/"<your_feature_file>.feature, <br/>
and implement the step functions under "./SelPyBehave/Src/steps/<Steps.py|your_python_file.py>" <br/>
and you thats it.<br/>

[Framework Structure]<br/>
  SelPyBehave<br/>
    &nbsp;&nbsp;|<br/>
    &nbsp;&nbsp;|_Core [basic setting related with WebDriver and configurations] <br/>
        &nbsp;&nbsp;&nbsp;&nbsp;|_Basic [ Classes for Selenium WebDriver ] <br/>
        &nbsp;&nbsp;&nbsp;&nbsp;|_Configuration [Classes for setting configuration for this framework] <br/>
    &nbsp;&nbsp;|_Logs [Used for Automation logs, Pending]<br/>
    &nbsp;&nbsp;|_Reports [for junit report(xml format) and json raw reports] <br/>
    &nbsp;&nbsp;|_Src<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;|_Features<br/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|_your_feature_files.feature <br/>
        &nbsp;&nbsp;&nbsp;&nbsp;|_steps<br/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|_step_definition_in_python_file <br/>
