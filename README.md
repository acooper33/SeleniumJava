Instructions:
* Install Intellij Community
* run "mvn clean install" to clear dependencies and download them based on the POM
* Install GitHub Copilot plugin into Intellij

Technologies currently included:
* slf4j.Logger with a loggerback backend to provide logging capabilities
* TestNG  for annotations/reporting/etc...
  * https://toolsqa.com/testng/what-is-testng/
  * testng.xml can be used to define test suites or executions using the group tag
  * Use "mvn test -Dsurefire.suiteXmlFiles=path/to/your/testng.xml" to run suite based on TestNG
  * Can generate an emailable report
* ChromeDriverManager (Requires newer Selenium)
  * No longer need to deal with chrome driver versions
* Maven for dependency management

Required to get up and running:
* Cucumber
  * Additional layer intended to align product and technical employees.
  * Additional layer makes maintenance and writing new cases slower
  * May help let technical people write testcases
* Can required parameters be made visible when calling an action/class
* Running on Linux Agent
  * Updated Browser.groovy to Apply properties to chromedriver
* Launcher
  * Github actions and workflows to setup AWS agents and launch testcases
    * https://docs.github.com/en/actions/about-github-actions/understanding-github-actions
    * https://www.blazemeter.com/blog/selenium-github
  * Jenkins to setup AWS agents and launch testcases
  * RedwoodHQ Server
* Reporting Solution
  * Send reports to testrail?
  * Use RedwoodHQ to control runs and manage reports?
    * Maybe keep RWHQ for regression runs and develop locally in intellij
  * testng emailable report :(
* Image Storage
  * Images aren't supposed to be stored in Git, they should be stored in AWS instead

Other potential items that can be integrated:
* Parallel Execution?
  * Selenium Grid
* Visual Comparison Tools
  * Sikuli - Image comparison tool (Free, Old pre AI)
    * https://www.guru99.com/sikuli-tutorial.html
    * http://sikulix.com/quickstart/
  * Applitools Eyes - Visual AI tool for image comparison (Paid?)
    * https://applitools.com/platform/eyes/
  * BrowserStack Percy - AI Visual Testing
    * https://www.browserstack.com/pricing?product=percy&utm_source=google&utm_medium=cpc&utm_platform=paidads&utm_content=692894559287&utm_campaign=Search-Competitor-Applitools-Global-High-Intent&utm_campaigncode=Applitools-Product-Percy+9032294&utm_term=p+applitools+eyes&cycle=annual
* Other AI Tools
  * testRigor: This tool offers a Selenium integration that can self-heal locators in your Selenium, Java, TestNG/JUnit code. It can store locators and corresponding page information, infer user intent for each locator, and use this information to find new locators for intended elements. This helps in reducing the time spent on test maintenance oai_citation:1,Selenium AI - testRigor AI-Based Automated Testing Tool.

Interesting Article:
* https://www.geeksforgeeks.org/top-ai-testing-tools-for-test-automation/
* https://testguild.com/7-innovative-ai-test-automation-tools-future-third-wave/