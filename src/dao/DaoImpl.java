package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.User;
import utility.InstaCourierUtil;

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
			tx.commit();
			
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(sdf.format(date));
	}
	
}