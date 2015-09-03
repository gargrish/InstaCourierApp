package rest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.logging.Logger;

import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stripe.Stripe;

import pojos.RestServiceResponse;
import pojos.User;
import utility.GlobalConstants;
import utility.InstaCourierUtil;
import utility.StripeWebService;
import utility.TwilioWebService;
import dao.DaoI;

@Path("/profile")
public class ProfileService {
	DaoI dao = InstaCourierUtil.getDaoInstance();
	Logger logger = Logger.getLogger("debug");

	@POST
	@Path("insertUserProfile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RestServiceResponse insertUserProfile(User user)
			throws SystemException {
		RestServiceResponse serviceResponse = new RestServiceResponse();
		try {
			if (dao.insertUser(user)) {
				serviceResponse.setResponse(true);
				logger.info("User[" + user.getId() + "] Inserted");
			} else {
				serviceResponse.setResponse(false);
				logger.info("Failed to insert User[" + user.getId() + "]");
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			serviceResponse.setResponse(false);
		}
		return serviceResponse;
	}

	@POST
	@Path("sendotpservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int sendOTPService(User user) throws SystemException {
		if (user != null && user.getMobileNumber() > 0) {
			int otp = 0;
			try {
				otp = (int) (Math.random() * 10000);
				if (TwilioWebService
						.sendOTPMessage(user.getMobileNumber(), otp)) {
					logger.info("otp sent :" + otp);
					return otp;
				} else {
					logger.info("Error While Sending Message");
					return 0;
				}
			} catch (Exception e) {
				logger.info(e.getMessage());
				return 0;
			}
		}
		return 0;
	}
}
