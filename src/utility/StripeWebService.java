package utility;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Customer;

import pojos.User;
import vo.UserResponseVO;

public class StripeWebService {

	public static UserResponseVO createCustomer(User user) {
		Logger logger = Logger.getLogger("debug");
		UserResponseVO userResponseVO = new UserResponseVO();
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("id", "stripeId" + user.getId());
		customerParams.put("email", user.getEmail());
		Map<String, Object> source = new HashMap<String, Object>();
		source.put("object", "card");
		source.put("number", user.getUserCardVO().getCardNumber() + "");
		source.put("exp_month", user.getUserCardVO().getExpMonth());
		source.put("exp_year", user.getUserCardVO().getExpYear());
		source.put("cvc", user.getUserCardVO().getCvv());
		source.put("name", user.getFirstName() + " " + user.getLastName());
		customerParams.put("source", source);
		try {
			Customer.create(customerParams);
			userResponseVO.setResponse(true);
		} catch (AuthenticationException e) {
			logger.info(e.getStackTrace().toString());
			userResponseVO.setResponse(false);
			userResponseVO.setErrorMsg("Authentication Exception");
		} catch (InvalidRequestException e) {
			logger.info(e.getStackTrace().toString());
			userResponseVO.setResponse(false);
			userResponseVO.setErrorMsg("Invalid Request Exception");
		} catch (APIConnectionException e) {
			logger.info(e.getStackTrace().toString());
			userResponseVO.setResponse(false);
			userResponseVO.setErrorMsg("API Connection Exception");
		} catch (CardException e) {
			logger.info(e.getStackTrace().toString());
			userResponseVO.setResponse(false);
			userResponseVO.setErrorMsg("Card Exception");
		} catch (APIException e) {
			logger.info(e.getStackTrace().toString());
			userResponseVO.setResponse(false);
			userResponseVO.setErrorMsg("API Exception");
		}
		return userResponseVO;
	}

}
