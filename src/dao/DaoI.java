package dao;

import pojos.User;
import vo.UserResponseVO;

public interface DaoI {

	public UserResponseVO insertUser(User user);
	public UserResponseVO getUserDetails(User user);
	public UserResponseVO checkUserExistence(long mobileNumber);

}
