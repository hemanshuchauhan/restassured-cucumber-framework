package model;

public class Tag {
	
	private Integer id;
    private String name;
    
    public Tag() {
		setId(32);
		setName("Jessy");		
	}
	
	public Tag(Integer id, String name) {
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
