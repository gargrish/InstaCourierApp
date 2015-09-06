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
import vo.PackageResponseVO;
import vo.UserResponseVO;
import dao.DaoI;
import pojos.Package;

@Path("/package")
public class PackageService {
	DaoI dao = InstaCourierUtil.getDaoInstance();
	Logger logger = Logger.getLogger("debug");


	@POST
	@Path("raisepackagerequest")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PackageResponseVO userAuthentication(Package pack) {
		PackageResponseVO packageResponse = null;
		try {
			packageResponse = dao.insertPackage(pack);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return packageResponse;
	}

}
