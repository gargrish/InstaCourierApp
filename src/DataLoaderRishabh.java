import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;


public class DataLoaderRishabh {

	public static void main(String[] args){
	System.out.println((new Date()).getTime());
		
	}
	/*	throws AuthenticationException, InvalidRequestException,
	
		   APIConnectionException, CardException, APIException  */
/*			    Stripe.apiKey = "sk_test_9hEr5VIanWPiPf9waJhqLZnL"; // stripe public
			                              // test key

			    final Map<String, Object> cardParams = new HashMap<String, Object>();
			    cardParams.put("number", "4386280523052821");
			    cardParams.put("exp_month", 12);
			    cardParams.put("exp_year", 2017);
			    cardParams.put("cvc", "834");
			    cardParams.put("name", "Rishabh Garg");
			    cardParams.put("address_line1", "807 CA Appts");
			    cardParams.put("address_line2", "Paschim Vihar");
			    cardParams.put("address_city", "New Delhi");
			    cardParams.put("address_zip", "110063");
			    cardParams.put("address_state", "Delhi");
			    cardParams.put("address_country", "India");

			    final Map<String, Object> chargeParams = new HashMap<String, Object>();
			    chargeParams.put("amount", 50);
			    chargeParams.put("currency", "usd");
			    chargeParams.put("card", cardParams);

			    final Charge charge = Charge.create(chargeParams);
			    System.out.println(charge);
			  }*/
/*		Configuration configuration = new Configuration();
	    configuration.configure("resources/hibernate.cfg.xml");

	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from User";
		String hql2 = "delete from PrivateChat";
		Query qry = session.createQuery(hql);
//		System.out.println(qry.executeUpdate());
//		tx.commit();
//		List<User> users = qry.list();
		//for()
		for(User list:users){
			System.out.println(list.getId());
		}
//		System.out.println(qry.list().size());
		session.close();
//		Query qry2 = session.createQuery(hql2);

//		List<PrivateChat> chats = qry.list();
//		System.out.println(chats.size());
		for(PrivateChat pv:chats){
			System.out.println(chats.get(chats.size()-1).getCreateTime());
//			System.out.println(pv.getId()+ " " + pv.getMsg() + " " +pv.getCreateTime());			
		}
		String hql = "from OTP";
		Query qry = session.createQuery(hql);
		List<OTP> poolRequest = qry.list();
		for(OTP otp:poolRequest){
		session.delete(otp);
		}
tx.commit();
		for(OTP otp:poolRequest){
			System.out.println(otp.getEmail() + " "+ otp.getPasscode());
		}
		
	//session.close();
		
		User user= new User();
		user.setName("Sahil Ajmani");
		user.setCompanyName("cisco");
		user.setContact("8861622290");
		user.setEmail("saajmani@cisco.com");
		Time startTime = new Time();
//		startTime.setId(1);
		startTime.setTime("9:30AM");
		Time endTime = new Time();
//		startTime.setId(2);
		startTime.setTime("11:30AM");
		user.setStartTime_pickUp(startTime);
		user.setStartTime_drop(endTime);
		Address address = new Address();
		address.setState("new Delhi");
		address.setAddressLine1("D117, Ajay Enclave");
		address.setAddressLine2("");
//		address.setId(1);
		user.setHomeAddress(address);
//		user.setId(1);
		session.save(user);
		System.out.println("user saved successfully ! "+user.getId());
		tx.commit();
		session.close();
		session=sessionFactory.openSession();
		Collection<User> result = UserUtil.getByName(session, "Sahil Ajmani");
		System.out.println(result);
		sessionFactory.close();
		
		String hql = "from OTP";
		Query qry = session.createQuery(hql);
		List<OTP> lst = qry.list();
		for(OTP otp:lst){
			System.out.println("Email : " + otp.getEmail());
			System.out.println("OTP : " + otp.getPasscode());
			System.out.println("Create Time : " + otp.getCreate_time());		
		}
	//	sessionFactory.close();
	   */
}	
		
		

