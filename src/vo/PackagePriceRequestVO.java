package vo;

import pojos.Package;

public class PackagePriceRequestVO {

	private Package pack;
	private String sourceZipCode;
	private String destinationZipCode;
	
	public String getDestinationZipCode() {
		return destinationZipCode;
	}
	public void setDestinationZipCode(String destinationZipCode) {
		this.destinationZipCode = destinationZipCode;
	}
	public Package getPack() {
		return pack;
	}
	public void setPack(Package pack) {
		this.pack = pack;
	}
	public String getSourceZipCode() {
		return sourceZipCode;
	}
	public void setSourceZipCode(String sourceZipCode) {
		this.sourceZipCode = sourceZipCode;
	}
	
}
