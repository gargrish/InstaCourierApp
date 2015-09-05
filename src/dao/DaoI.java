package dao;

import pojos.User;
import vo.UserResponseVO;

public interface DaoI {

	UserResponseVO insertUser(User user);

}
