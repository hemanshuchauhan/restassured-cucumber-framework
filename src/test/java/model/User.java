package model;

public class User {
	
	
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phone;
	private int userStatus;
	
	public User() {
		setId(19);
		setUsername("testuser");
		setFirstname("test");
		setLastname("user");
		setEmail("test.user@testing.com");
		setPassword("password123");
		setPhone("07898889878");
		setUserStatus(0);
	}
	
	public User(int id, String username, String firstname, String lastname, String email, String password, String Phone, int userStatus) {
		setId(19);
		setUsername(username);
		setFirstname(firstname);
		setLastname(lastname);
		setEmail(email);
		setPassword(password);
		setPhone(phone);
		setUserStatus(userStatus);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastnamename() {
		return this.lastname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	
	public int getUserStatus() {
		return this.userStatus;
	}

}
