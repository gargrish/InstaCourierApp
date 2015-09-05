package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.stripe.Stripe;

import pojos.User;
import utility.GlobalConstants;
import utility.InstaCourierUtil;
import utility.StripeWebService;
import vo.UserResponseVO;

public class DaoImpl implements DaoI {
	SessionFactory sessionFactory = InstaCourierUtil
			.getSessionFactoryInstance();
	Logger logger = Logger.getLogger("debug");

	@Override
	public UserResponseVO insertUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserResponseVO userResponseVO = new UserResponseVO();

		try {
			user.setCreated(this.getCurrentTime());
			session.save(user);
			Stripe.apiKey = GlobalConstants.STRIPE_API_KEY;
			UserResponseVO stripeResponse = StripeWebService
					.createCustomer(user);
			if (stripeResponse.isResponse()) {
				tx.commit();
				userResponseVO.setResponse(true);
				userResponseVO.setUser(user);
			} else {
				tx.rollback();
				userResponseVO.setResponse(false);
				userResponseVO
						.setErrorMsg("Error while creating user using Stripe API : "
								+ stripeResponse.getErrorMsg());
			}
		} catch (Exception e) {
			logger.info(e.getStackTrace().toString());
			tx.rollback();
			userResponseVO.setResponse(false);
			userResponseVO.setErrorMsg("Error while inserting user in DB");
		} finally {
			session.close();
		}
		return userResponseVO;
	}

	private Date getCurrentTime() throws ParseException {
		Date date = new Date();
		System.out.println("Date" + date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		return sdf.parse(sdf.format(date));
	}

}