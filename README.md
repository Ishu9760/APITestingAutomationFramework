**API Testing Automation Framework**


API Automation Framework with CRUD of Restful Booker

mvn test -Dsurefire.suiteXmlFiles=testng.xml

**Tech Stack**

1. Rest Assured
2. Java
3. Apache POI, TestNG Maven
4. Jackson and GSON
5. Log42
6. Allure Report
7. Full Folder Structure(Hybrid) Framework
8. Jenkins File

Run

**Basic Create Test**

mvn clean test

**Integration Test (Create Booking and Create Token, Update and Delete Booking)**

mvn clean test -DsuiteXmlFile=testng-integration.xml
