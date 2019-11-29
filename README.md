Swagger Petstore API Tests (Cucumber - Rest Assured)
=====================================
This is automation suite is designed to test the Swagger Pet store POST /pet request (Additonal services have also been included but were not essential).

The project has 12 scenarios that that can be located within the feature files: 
 - src/test/resources/OrderTests.feature
 - src/test/resources/PetTests.feature
 - src/test/resources/UserTests.feature  

**OrderTests.feature scenarios include:**
    Scenario: Correct error message is provided when searching for an order that does not exist.
    Scenario: Users are able to place orders for pets
    Scenario: Users are able to search for orders by its id
    Scenario: Users are able to place orders for available pets
    Scenario: Users are NOT able to place orders for available pets (fails within test suite, this is error in the API rather than the automation suite assuming users should not be able to create orders for pets that are not available).

**PetTests.feature scenarios include:**
    Scenario: Users are able to add pets to the system
    Scenario: Users are able to delete pets from the system
    Scenario: Users are able to add pets that have multiple tags
    Scenario: Users are able to add pets that have no tags
    Scenario: Id's are automatically generated for pets when not supplied with the request
    Scenario: Adding a pet with no body for the request results in a 400 response 
    
**UserTests.feature scenarios include:**
    Scenario: Users are searchable by their username
    
*Important Note:* scenarios need to have the tag **@smokeTest** in order to be included in test executions
```
You will need:
- Java 1.8 installed (Does not work with Java below 1.8)
- Maven Installed (I use version 3.5.2)
- Eclipse (Or another Java IDE)
```
**Important: This suite should work on both windows and mac platforms however has only been tested on a Mac. If possible please use a Mac to execute the test suite**

In order to execute the automation suite navigate to the Project directory within a Terminal/CMD window and run the command: **'mvn clean test'**.

12 scenarios will be executed. Report file can be found *'target/reports/test-report/index.html'*
1 of the 12 test scenarios (Users are NOT able to place orders for available pets) within the OrderTests feature file will fail. The test is coded correctly, this is a legitimate failure when using the assumption that users should not be able to place orders for pets that are not available.

