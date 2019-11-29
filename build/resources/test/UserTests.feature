Feature: User Tests
  This feature includes tests that test the user RESTFul services

@smokeTest
Scenario: Users are searchable by their username
    Given a valid user exists
    When I search for the user by their username
    Then the user is located
    


