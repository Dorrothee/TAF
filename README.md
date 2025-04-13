# ***TA Framework***

## Project Overview
This project was cloned from the previous task (SeleniumWebDriver project) for enhancing via TAF implementation.

## Prerequisites
- Java Development Kit (JDK) installed
- TestNG framework, Selenium WebDriver set up in your project

## Setup Instructions
1. **Clone repository**
2. **Add (check) dependencies**: Selenium WebDriver, TestNG, WebDriverManager, log4j.
3. **Run Tests**: Right-click on the desired test to run

## The framework should have
- WebDriverManager for managing drivers for different browsers; 
- PageObject / PageFactory for abstract pages; 
- Necessary business model (business objects for dedicated entities); 
- Property files with test data for different environments (at least 2); 
- XML suites for Smoke and Regression tests; 
- Possibility to make a screenshot in case of test failure. The log should have information about the saved screenshot in this case; 
- Flexibility on different parameters e.g., browser, test suite, environment (this flexibility will help CI integration in future);
- Add logging of every step (with log4j or any similar lib) for your solution implemented based on previous modules.
  Configure logs format in informative way
  Demonstrate usage of different log levels (debug, action, error, etc)
  Configure ability to write logs in console and to save logs in a file (a new file should be created for each day). By default logs are written in console and are stored in file.
  Test results should present on job graphics, and screenshots should be archived as artifacts.
