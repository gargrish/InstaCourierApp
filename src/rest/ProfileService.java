package rest;

import java.util.logging.Logger;

import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojos.User;
import utility.InstaCourierUtil;
import utility.TwilioWebService;
import vo.UserResponseVO;
import dao.DaoI;

@Path("/profile")
public class ProfileService {
	DaoI dao = InstaCourierUtil.getDaoInstance();
	Logger logger = Logger.getLogger("debug");

	@POST
	@Path("insertUserProfile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponseVO insertUserProfile(User user) throws SystemException {
		UserResponseVO userResponse = null;
		try {
			userResponse = dao.insertUser(user);
		} catch (Exception e) {
			logger.info(e.getStackTrace().toString());
			userResponse = new UserResponseVO();
			userResponse.setResponse(false);
			userResponse.setErrorMsg("Failed to insert User[" + user.getId()
					+ "] : " + e.getMessage());
		}
		return userResponse;
	}

	@POST
	@Path("sendotpservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int sendOTPService(User user) throws SystemException {
		if (user != null && user.getMobileNumber() > 0) {
			UserResponseVO checkMobileExistence = dao.checkUserExistence(user
					.getMobileNumber());
			if (!checkMobileExistence.isResponse()) {
				int otp = 0;
				try {
					otp = (int) (1000 + Math.random() * 8999);
					if (TwilioWebService.sendOTPMessage(user.getMobileNumber(),
							otp)) {
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
		}
		return 0;
	}

	@POST
	@Path("userloginservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponseVO userAuthentication(User user) {
		UserResponseVO userResponse = null;
		try {
			userResponse = dao.getUserDetails(user);
		} catch (Exception e) {
			logger.info(e.getStackTrace().toString());
			userResponse = new UserResponseVO();
			userResponse.setResponse(false);
			userResponse.setErrorMsg("Failed to get User Details :"
					+ e.getMessage());
		}
		return userResponse;
	}

}
