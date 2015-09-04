package vo;

import pojos.User;

public class UserResponseVO {

	private boolean response;
	private String errorMsg;
	private User user;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isResponse() {
		return response;
	}
	
	public void setResponse(boolean response) {
		this.response = response;
	}

}
