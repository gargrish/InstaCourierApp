package pojos;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class User implements Serializable{
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long mobileNumber;
	private UserCardVO userCardVO;
	private Date created;
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public UserCardVO getUserCardVO() {
		return userCardVO;
	}
	public void setUserCardVO(UserCardVO userCardVO) {
		this.userCardVO = userCardVO;
	}

	
}
