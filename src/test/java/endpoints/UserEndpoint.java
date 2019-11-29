package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;

public class UserEndpoint extends BaseEndpoints {
	private final String USER_ENDPOINT_PATH = "user/";
	private User defaultUser;
	
	public UserEndpoint() {
		super();
		defaultUser = new User();
	}
	
	public String getPath() {
		return this.USER_ENDPOINT_PATH;
	}
	
	public User getDefaultUser() {
		return this.defaultUser;
	}
	
	public Response getUserByUsername(RequestSpecification request) {
		return getUserByUsername(request, getDefaultUser().getUsername());
	}
	
	public Response getUserByUsername(RequestSpecification request, String username) {
		String url = getBaseUrl() + this.getPath() + username;
		return sendRequest(request, BaseEndpoints.GET_REQUEST, url, null);
	}
	
	
	
	public Response createUser(RequestSpecification request) {		
        return createUser(
				request,
				defaultUser);
	}
	
	public Response createUser(RequestSpecification request, User user) {
		String url = getBaseUrl() + this.getPath();
		return sendRequest(request, BaseEndpoints.POST_REQUEST, url, user);
	}	

}
