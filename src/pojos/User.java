package pojos;

public class User {
	
	private int id;
	private String name;
	private String fullAddress;
	private String email;
	private int mobileNumber;
	private UserCardVO userCardVO;
	
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
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public UserCardVO getUserCardVO() {
		return userCardVO;
	}
	public void setUserCardVO(UserCardVO userCardVO) {
		this.userCardVO = userCardVO;
	}

	
}
