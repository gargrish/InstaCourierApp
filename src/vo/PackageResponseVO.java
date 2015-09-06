package vo;

import pojos.User;

public class PackageResponseVO {

	private boolean response;
	private String errorMsg;
	public boolean isResponse() {
		return response;
	}
	public void setResponse(boolean response) {
		this.response = response;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
}
