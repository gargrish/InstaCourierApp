package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pojos.User;
import pojos.Package;
import utility.GlobalConstants;
import utility.InstaCourierUtil;
import utility.StripeWebService;
import vo.PackageResponseVO;
import vo.UserResponseVO;

import com.stripe.Stripe;

public class DaoImpl implements DaoI {
	SessionFactory sessionFactory = InstaCourierUtil
			.getSessionFactoryInstance();
	Logger logger = Logger.getLogger("debug");

	@Override
	public UserResponseVO insertUser(User user) {
		UserResponseVO checkUserResponse = checkUserExistence(user.getEmail());
		UserResponseVO userResponseVO = new UserResponseVO();
		if (!checkUserResponse.isResponse()) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

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
		} else {
			userResponseVO.setErrorMsg(checkUserResponse.getErrorMsg());
			userResponseVO.setResponse(false);
		}
		return userResponseVO;
	}

	private Date getCurrentTime() throws ParseException {
		Date date = new Date();
		System.out.println("Date" + date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		return sdf.parse(sdf.format(date));
	}

	@Override
	public UserResponseVO getUserDetails(User user) {
		UserResponseVO userResponseVO = new UserResponseVO();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", user.getEmail())).add(
				Restrictions.eq("password", user.getPassword()));
		try {
			List<User> users = criteria.list();
			if (users != null && users.size() > 0) {
				userResponseVO.setUser(users.get(0));
				userResponseVO.setResponse(true);
			} else {
				userResponseVO.setResponse(false);
				userResponseVO.setErrorMsg("No Results Found");
			}
		} catch (Exception e) {
			userResponseVO.setResponse(false);
			userResponseVO.setErrorMsg("Error while fetching results from DB");
		} finally {
			session.close();
		}
		return userResponseVO;
	}

	private UserResponseVO checkUserExistence(String email) {
		UserResponseVO userResponseVO = new UserResponseVO();
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(User.class).add(
					Restrictions.eq("email", email));
			if (criteria.list().size() > 0) {
				userResponseVO.setResponse(true);
				userResponseVO.setErrorMsg("User with email [" + email
						+ "] already exists");
			} else {
				userResponseVO.setResponse(false);
			}
		} catch (Exception e) {
			userResponseVO.setResponse(true);
			userResponseVO.setErrorMsg("Error while fetching user for email["
					+ email + "]");
		} finally {
			session.close();
		}
		return userResponseVO;
	}

	public UserResponseVO checkUserExistence(long mobileNumber) {
		UserResponseVO userResponseVO = new UserResponseVO();
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(User.class).add(
					Restrictions.eq("mobileNumber", mobileNumber));
			if (criteria.list().size() > 0) {
				userResponseVO.setResponse(true);
				userResponseVO.setErrorMsg("User with mobile number ["
						+ mobileNumber + "] already exists");
			} else {
				userResponseVO.setResponse(false);
			}
		} catch (Exception e) {
			userResponseVO.setResponse(true);
			userResponseVO
					.setErrorMsg("Error while fetching user for mobile number ["
							+ mobileNumber + "]");
		} finally {
			session.close();
		}
		return userResponseVO;
	}

	@Override
	public PackageResponseVO insertPackage(Package pack) {
		// Package packageEntry=new Package();
		PackageResponseVO packageResponse = new PackageResponseVO();
		try {
			// packageEntry.setCost(pack.getCost());
			// packageEntry.setDeliveryDate(pack.getDeliveryDate());
			// packageEntry.setDeliveryTime(pack.getDeliveryTime());
			// packageEntry.setDestinationFullAdress(pack.g);
			pack.setCreated(this.getCurrentTime());
			pack.setOpenOrder(true);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(pack);
			tx.commit();
			session.close();
			packageResponse.setResponse(true);
			packageResponse.setErrorMsg("success");
		} catch (ParseException e) {
			e.printStackTrace();
			packageResponse.setResponse(false);
			packageResponse.setErrorMsg("Failure in raising request as "
					+ e.getMessage());
		}
		return packageResponse;
	}
}