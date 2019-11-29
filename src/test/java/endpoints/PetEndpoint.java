package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import model.Tag;
import stepdefs.World;

public class PetEndpoint extends BaseEndpoints {
	private final String PET_ENDPOINT_PATH = "pet/";
	private Pet defaultPet;

	public PetEndpoint() {
		super();
		defaultPet = new Pet();
	}

	public String getPath() {
		return this.PET_ENDPOINT_PATH;
	}

	public Pet getDefaultPet() {
		return this.defaultPet;
	}

	public Response addPetWithBody(RequestSpecification request, String body) {
		String url =  getBaseUrl() + this.getPath();
		request.body(body);
		return sendRequest(request, BaseEndpoints.POST_REQUEST, url, null);
	}
	
	public void addPet(World world) {
		world.setRequest(getRequestWithJSONHeaders());
		world.setResponse(addPet(world.getRequest()));
	}
	
	public void addPet(World world, Pet pet) {
		world.setPet(pet);
		world.setRequest(getRequestWithJSONHeaders());
		world.setResponse(addPet(world.getRequest(), pet));
	}

	public Response addPet(RequestSpecification request) {
		return addPet(request, getDefaultPet());
	}

	public Response addPet(RequestSpecification request, Pet pet) {
		String url = getBaseUrl() + this.getPath();
		return sendRequest(request, BaseEndpoints.POST_REQUEST, url, pet);
	}

	public Response deletePet(RequestSpecification request) {
		return deletePet(request, getDefaultPet());
	}

	public Response deletePet(RequestSpecification request, Pet pet) {

		String id = pet.getId().toString();
		String url = getBaseUrl() + this.getPath() + id;
		return sendRequest(request, BaseEndpoints.DELETE_REQUEST, url, null);
	}

	public Response getPetById(RequestSpecification request) {
		return getPetById(request, getDefaultPet().getId().toString());
	}

	public Response getPetById(RequestSpecification request, String id) {
		String url = getBaseUrl() + this.getPath() + id;
		return sendRequest(request, BaseEndpoints.GET_REQUEST, url, null);
	}

	public void verifyPetValuesAreAsExpected(Response response, Pet pet) {
		String expectedId = pet.getId().toString();
		String expectedCategoryId = pet.getCategory().getId().toString();
		String expectedCategoryName = pet.getCategory().getName();
		String expectedName = pet.getName();
		String expectedPhotoUrls[] = pet.getPhotoUrls();
		Tag expectedTags[] = pet.getTag();
		String expectedStatus = pet.getStatus();

		// get Tag expectedIds and names
		String[] expectedTagIds = new String[expectedTags.length];
		String[] expectedTagNamess = new String[expectedTags.length];
		for (int i = 0; i < expectedTags.length; i++) {
			expectedTagIds[i] = expectedTags[i].getId().toString();
			expectedTagNamess[i] = expectedTags[i].getName();
		}

		verifyResponseKeyValues("id", expectedId, response);
		verifyNestedResponseKeyValues("category", "id", expectedCategoryId, response);
		verifyNestedResponseKeyValues("category", "name", expectedCategoryName, response);
		verifyResponseKeyValues("name", expectedName, response);
		verifyNestedArrayValueResponseKeyValues("photoUrls", expectedPhotoUrls, response);
		verifyNestedArrayMapResponseKeyValues("tags", "id", expectedTagIds, response);
		verifyNestedArrayMapResponseKeyValues("tags", "name", expectedTagNamess, response);
		verifyResponseKeyValues("status", expectedStatus, response);
	}
	
	public void verifyPetHasAnId(Response response) {
		String idVal = response.jsonPath().getString("id");
		verifyTrue(idVal != null);
		verifyTrue(!idVal.equalsIgnoreCase(""));
		verifyTrue(Long.parseLong(idVal) > 0);
	}

}
