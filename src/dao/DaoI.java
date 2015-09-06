package dao;

import pojos.User;
import pojos.Package;
import vo.PackageResponseVO;
import vo.UserResponseVO;

public interface DaoI {

	public UserResponseVO insertUser(User user);
	public UserResponseVO getUserDetails(User user);
	public UserResponseVO checkUserExistence(long mobileNumber);
	public PackageResponseVO insertPackage(Package pack);

}
