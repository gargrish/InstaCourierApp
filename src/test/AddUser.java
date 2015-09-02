package test;

import pojos.User;
import dao.DaoImpl;

public class AddUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoImpl db=new DaoImpl();
		User user=new User();
		user.setEmail("vidurthakral@gmail.com");
		user.setPassword("dhsfk");
		user.setMobileNumber(965443841);
		user.setFirstName("vidur");
		System.out.println(db.insertUser(user));
	}

}
