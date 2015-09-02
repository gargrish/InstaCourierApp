package utility;

import java.util.HashMap;
import java.util.Map;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Customer;

import pojos.User;

public class StripeWebService {
	
	public static boolean createCustomer(User user){
		Map<String,Object> customerParams = new HashMap<String, Object>();
		customerParams.put("id", "stripeId"+user.getId());
		customerParams.put("email", user.getEmail());
		Map<String,Object> source = new HashMap<String, Object>();
		source.put("object", "card");
		source.put("number", user.getUserCardVO().getCardNumber()+"");
		source.put("exp_month", user.getUserCardVO().getExpMonth());
		source.put("exp_year", user.getUserCardVO().getExpYear());
		source.put("cvc", user.getUserCardVO().getCvv());
		source.put("name", user.getFirstName()+" "+user.getLastName());
		customerParams.put("source", source);
		try {			
			Customer.create(customerParams);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidRequestException e) {
			e.printStackTrace();
			return false;
		} catch (APIConnectionException e) {
			e.printStackTrace();
			return false;
		} catch (CardException e) {
			e.printStackTrace();
			return false;
		} catch (APIException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
