package model;

public class Order {
	
	
	private Integer id;
	private int petId;
	private int quantity;
	private String shipDate;
	private String status;
	private boolean complete;
	
	public Order() {
		setId(32);
		setPetId(3);
		setQuantity(2);
		setShipDate("2019-02-28T14:12:44.922Z");
		setStatus("placed");
		setComplete(false);		
	}
	
	public Order(Integer id, int petId, int quantity, String shipDate, String status, boolean complete) {
		setId(id);
		setPetId(petId);
		setQuantity(quantity);
		setShipDate(shipDate);
		setStatus(status);
		setComplete(complete);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setPetId(int petId) {
		this.petId = petId;
	}
	
	public int getPetId() {
		return this.petId;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	
	public String getShipDate() {
		return this.shipDate;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	public boolean getComplete() {
		return this.complete;
	}

}
