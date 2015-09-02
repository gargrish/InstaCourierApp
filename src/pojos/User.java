package pojos;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class User implements Serializable{
	
	private int id;
	private String name;
	private String fullAddress;
	private String email;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
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
