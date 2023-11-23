# Automation_klimber
Automated tests suite with Selenium and Java for Klimber.

# Test:
* The main test is located in: ```src/test/java/selenium/klimber/test/KlimberTest.java```
* The included chromedriver file in the resources folder is for Windows. To run the tests from another OS, download the appropriate version from: https://chromedriver.chromium.org/
* This project uses JDK version 21.

# Configurable properties:
* ```url.properties``` contains the enviroment URL.
* ```user.properties``` has all the personal information used to fill in the insurance forms.
* ```insurance.properties``` has all the values to validate the insurance costs. 