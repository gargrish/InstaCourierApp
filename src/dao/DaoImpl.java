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

public class DaoImpl implements DaoI {
	SessionFactory sessionFactory = InstaCourierUtil
			.getSessionFactoryInstance();
	Logger logger = Logger.getLogger("debug");

	@Override
	public boolean insertUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			user.setCreated(this.getCurrentTime());
			session.save(user);
			Stripe.apiKey = GlobalConstants.STRIPE_API_KEY;
			if (StripeWebService.createCustomer(user)) {
				tx.commit();
			} else {
				tx.rollback();
				return false;
			}
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	private Date getCurrentTime() throws ParseException {
		Date date = new Date();
		System.out.println("Date" + date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		return sdf.parse(sdf.format(date));
	}

}