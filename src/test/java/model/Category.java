package model;

public class Category {
	
	private Integer id;
    private String name;
    
    public Category() {
		setId(32);
		setName("Jessy");		
	}
	
	public Category(Integer id, String name) {
		setId(id);
		setName(name);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
