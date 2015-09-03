package utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

public class TwilioWebService {
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC70e25f62148d6f313699f32d9e56b099";
	public static final String AUTH_TOKEN = "fe51f4c12dfc8064353d131e505badde";

	public static boolean sendOTPMessage(long mobileNumber,int otp){
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		String body = "Instant Courier Code : "+otp;

		// Build the parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("To", "+1"+mobileNumber));
		params.add(new BasicNameValuePair("From", "+12155155023"));
		params.add(new BasicNameValuePair("Body", body));
		
		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		try {
			Message message = messageFactory.create(params);
		} catch (TwilioRestException e) {
			e.printStackTrace();
			return false;
		}
		//message.getSid());
		return true;
	}
}