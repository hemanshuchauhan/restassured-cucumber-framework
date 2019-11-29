package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import endpoints.UserEndpoint;

public class UserEndpointStepDefinitions {

	private World world;
	private UserEndpoint userEndpoint = new UserEndpoint();

	public UserEndpointStepDefinitions(World world) {
		this.world = world;
	}
	
	@Given("^a valid user exists$")
	public void a_valid_user_exists() {
		world.setRequest(userEndpoint.getRequestWithJSONHeaders());
		world.setResponse(userEndpoint.createUser(world.getRequest()));
		userEndpoint.verifyResponseStatusValue(world.getResponse(), UserEndpoint.SUCCESS_STATUS_CODE);
	}
	
	@When("I search for the user by their username$")
	public void i_search_for_the_user_by_their_username() {
		world.setResponse(userEndpoint.getUserByUsername(world.getRequest()));
	}
	
    @Then("the user is located$")
    public void the_user_is_located() {
    	
    }

	

}
