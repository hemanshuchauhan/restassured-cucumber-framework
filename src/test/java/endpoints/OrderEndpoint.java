package endpoints;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Order;

public class OrderEndpoint extends BaseEndpoints{
	public static final int INVALID_ORDER_STATUS_CODE = 400;
	private final String ORDER_ENDPOINT_PATH = "store/order/";
	private Order defaultOrder;
	
	public OrderEndpoint() {
		super();
		defaultOrder = new Order();
	}
	
	public String getPath() {
		return this.ORDER_ENDPOINT_PATH;
	}
	
	public Response getOrderById(RequestSpecification request, String id) {
		String url = getBaseUrl() + this.getPath() + id;
		return sendRequest(request, BaseEndpoints.GET_REQUEST, url, null);
	}
	
	public Response placeOrder(RequestSpecification request) {
		return placeOrder(
				request,
				defaultOrder);
	}
	
	public Response placeOrder(RequestSpecification request, Order order) {
		String url = getBaseUrl() + this.getPath();
		return sendRequest(request, BaseEndpoints.POST_REQUEST, url, order);
	}
	
	public Order getDefaultOrder() {
		return this.defaultOrder;
	}
	
	public void verifyOrderValuesAreAsExpected(Response response, Order order) {
		String id = order.getId().toString();
		String petId = Integer.toString(order.getPetId());
		String quantity = Integer.toString(order.getQuantity());
		String shipDate = prepareShipDate(order.getShipDate());
		String status = order.getStatus();
		String complete = Boolean.toString(order.getComplete());
		
		verifyResponseKeyValues("id", id, response);
		verifyResponseKeyValues("petId", petId, response);
		verifyResponseKeyValues("quantity", quantity, response);
		verifyResponseKeyValues("shipDate", shipDate, response);
		verifyResponseKeyValues("status", status, response);
		verifyResponseKeyValues("complete",complete, response);
		
	}
	
	private String prepareShipDate(String dateString) {
		return dateString.replace("Z", "+0000");
	}

}
