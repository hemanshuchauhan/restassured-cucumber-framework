Feature: Order Tests
	This feature includes tests that test the store order RESTFul services

@smokeTest
Scenario: Correct error message is provided when searching for an order that does not exist 
    Given the Swagger Petstore API is available
    When I search for an order with an id value of '15787678' 
    Then the requests response will contain the value 'Order not found' for the 'message' field 
 
@smokeTest
Scenario: Users are able to place orders for pets
    Given the Swagger Petstore API is available
    When I place an order for a pet with an order id of '58' 
    Then the order request response has a '200' response code
    And the order requests response contains the correct json data

@smokeTest
Scenario: Users are able to search for orders by its id
		Given an order exists for a pet
		When I search for the order by its id
		Then the complete order is returned
		
@smokeTest
Scenario: Users are able to place orders for available pets
		Given a cat is 'available'
		Then I am able to place an order for a cat
		
@smokeTest
Scenario: Users are NOT able to place orders for available pets
		Given a cat is 'unavailable'
		Then I am not able to place an order for a cat

