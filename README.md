**Perekupi UAT Automation Framework**

This project contains automated User Acceptance Tests (UAT) for the Perekupi web application.
The framework is built using Java, Selenium WebDriver, TestNG, Page Object Model (POM), WebDriverManager, and ExtentReports for detailed reporting.

**Project Structure**

src/test/java
 ├── pages
 │     ├── LoginPages.java
 │     └── HomePage.java
 ├── tests
 │     ├── BaseTest.java
 │     ├── LoginTests.java
 │     └── TableAndFiltersTests.java
 └── utils
       ├── ExtentManager.java
       ├── ExtentTestNGListener.java
       └── ScreenshotUtil.java

src/test/resources
 └── testng.xml

extent-report.html
pom.xml

**Features**

Automated UAT scenarios for Login, Filters, Comments, and Table interactions

Page Object Model (POM) design

TestNG test execution

ExtentReports (HTML) with screenshots

WebDriverManager integrated

Fully modular and maintainable architecture


**How to Run**

Install Java (JDK 17 or above recommended)

Import project into IntelliJ IDEA or any Java IDE


**Run tests using:**

testng.xml



**Reporting**

After execution, the report is generated at:

/extent-report.html


It includes:

Test logs

Pass/Fail status

Screenshots (Base64)

Execution timestamps


**GitHub Repository**

https://github.com/Dinesh-2311/Perekupi_UAT_Project

👤 Author

Dinesh Sai Gopi Putchakayala
