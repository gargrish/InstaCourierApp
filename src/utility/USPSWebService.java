package utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import pojos.Package;

public class USPSWebService {

	public static String fetchPriceOfPackage(Package pack,String origZipCode, String destZipCode)
    {
        String userName = "249INSTA3386";
        String originalZipcode = origZipCode;
        String destinationZipcdoe = destZipCode;
        double weightInOunces = pack.getWeight()*16;
        try {
            String xmlRequest = "<RateV4Request USERID=\"" + userName + "\">" +
                    " <Revision>2</Revision>" +
                    " <Package ID=\""+pack.getId()+"\">" +               //Package ID can be a unique key
                    " <Service>PRIORITY MAIL EXPRESS</Service>" +
                    " <ZipOrigination> " + originalZipcode + "</ZipOrigination>" +
                    " <ZipDestination> " + destinationZipcdoe + "</ZipDestination> " +
                    " <Pounds>"+ pack.getWeight() +"</Pounds> " +
                    " <Ounces>" + weightInOunces + "</Ounces> "+
                    " <Container /> " +
                    " <Size>REGULAR</Size> " +
                    " <Width>"+pack.getBreadth()+"</Width> " +
                    " <Length>"+pack.getLength()+"</Length> " +
                    " <Height>"+pack.getHeight()+"</Height> " +
                    " <Girth>10</Girth> " +
                    " </Package> " +
                    " </RateV4Request>";
            String tempUrl = "http://production.shippingapis.com/ShippingAPI.dll";
            URL url = new URL(tempUrl);
            String tempUrlParams = "API=RateV4";
            tempUrlParams += "&XML=" + xmlRequest;
            
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
//            con.setDoInput(true);
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    		wr.writeBytes(tempUrlParams);
    		wr.flush();
    		wr.close();

            int responseCode = con.getResponseCode();
            System.out.println(responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            String responsePrice = response.substring(response.indexOf("<Rate>")+6, response.indexOf("</Rate>"));
            System.out.println(response.substring(response.indexOf("<Rate>")+6, response.indexOf("</Rate>")));
            System.out.println(responseCode);
            return responsePrice;

        } catch (Exception ignoredException) {
        	ignoredException.printStackTrace();
        	return "Exceptiion while getting price";
        }
    }
}
