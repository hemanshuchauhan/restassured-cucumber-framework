Feature: Pet Tests
This feature includes tests that test the pet RESTFul services

@smokeTest
Scenario: Users are able to add pets to the system
    Given the Swagger Petstore API is available
    When I add a Pet to the system 
    Then the pet request response has a '200' response code
    And the pet requests response contains the correct json data
    

@smokeTest
Scenario: Users are able to delete pets from the system
    Given a pet exists
    When I delete the pet
    And then search for the pet by it's id 
    Then the requests response will contain the value 'Pet not found' for the 'message' field
    
@smokeTest
Scenario: Users are able to add pets that have multiple tags
    Given the Swagger Petstore API is available
    Then I can add a pet that has multiple tags
    
@smokeTest
Scenario: Users are able to add pets that have no tags
    Given the Swagger Petstore API is available
    Then I can add a pet that has no tags
    
@smokeTest
Scenario: Id's are automatically generated for pets when not supplied with the request
    Given the Swagger Petstore API is available
    When I add a pet to the system without providing an id value
    Then an id is automatically generated for the added pet
    
@smokeTest
Scenario: Adding a pet with no body for the request results in a 400 response
    Given the Swagger Petstore API is available
    When I add a pet and the json body is malformed and consists of only '{'
    Then the pet request response has a '400' response code
    Then the requests response will contain the value 'bad input' for the 'message' field


