package rest;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojos.Package;
import utility.InstaCourierUtil;
import vo.PackageResponseVO;
import dao.DaoI;

@Path("/package")
public class PackageService {
	DaoI dao = InstaCourierUtil.getDaoInstance();
	Logger logger = Logger.getLogger("debug");


	@POST
	@Path("createpackagerequest")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PackageResponseVO createPackageRequest(Package pack) {
		PackageResponseVO packageResponse = new PackageResponseVO();
		try {
			packageResponse = dao.insertPackage(pack);
		} catch (Exception e) {			
			packageResponse.setResponse(false);
			packageResponse.setErrorMsg("Error while inserting in Package Service - "+e.getMessage());
		}
		return packageResponse;
	}

}
