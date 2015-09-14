package pojos;

import java.io.Serializable;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Package implements Serializable {

	private int id; // unique id for each package - will help us to track.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String sourceFullAddress;

	public String getSourceFullAddress() {
		return sourceFullAddress;
	}

	public void setSourceFullAddress(String sourceFullAddress) {
		this.sourceFullAddress = sourceFullAddress;
	}

	private double sourceLatitude;

	public double getSourceLatitude() {
		return sourceLatitude;
	}

	public void setSourceLatitude(double sourceLatitude) {
		this.sourceLatitude = sourceLatitude;
	}

	private double sourceLongitude;
	private String destinationFullAddress;
	private double destinationLatitude;
	private double destinationLongitude;
	private double weight;
	private double length;
	private double breadth;
	private double height;
	private boolean isFragile;
	private String specialInstruction;

	public double getSourceLongitude() {
		return sourceLongitude;
	}

	public void setSourceLongitude(double sourceLongitude) {
		this.sourceLongitude = sourceLongitude;
	}

	public String getDestinationFullAddress() {
		return destinationFullAddress;
	}

	public void setDestinationFullAddress(String destinationFullAddress) {
		this.destinationFullAddress = destinationFullAddress;
	}

	public double getDestinationLatitude() {
		return destinationLatitude;
	}

	public void setDestinationLatitude(double destinationLatitude) {
		this.destinationLatitude = destinationLatitude;
	}

	public double getDestinationLongitude() {
		return destinationLongitude;
	}

	public void setDestinationLongitude(double destinationLongitude) {
		this.destinationLongitude = destinationLongitude;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean getIsFragile() {
		return isFragile;
	}

	public void setIsFragile(boolean isFragile) {
		this.isFragile = isFragile;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	private String deliveryDate;
	private boolean isOpenOrder;
	private double cost;
	private Date created;
	private long receiverMobileNumber;
	private int securityCode;
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public boolean getIsOpenOrder() {
		return isOpenOrder;
	}

	public void setIsOpenOrder(boolean isOpenOrder) {
		this.isOpenOrder = isOpenOrder;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public long getReceiverMobileNumber() {
		return receiverMobileNumber;
	}

	public void setReceiverMobileNumber(long receiverMobileNumber) {
		this.receiverMobileNumber = receiverMobileNumber;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	// private boolean hasSecurityCode;
	/*
	 * public int getId() { return id; } public void setId(int id) { this.id =
	 * id; } public User getUser() { return user; } public void setUser(User
	 * user) { this.user = user; } public String getSourceFullAdress() { return
	 * sourceFullAdress; } public void setSourceFullAdress(String
	 * sourceFullAdress) { this.sourceFullAdress = sourceFullAdress; } public
	 * Double getSourceLattitude() { return sourceLattitude; } public void
	 * setSourceLattitude(Double sourceLattitude) { this.sourceLattitude =
	 * sourceLattitude; } public Double getSourceLongitude() { return
	 * sourceLongitude; } public void setSourceLongitude(Double sourceLongitude)
	 * { this.sourceLongitude = sourceLongitude; } public String
	 * getDestinationFullAdress() { return destinationFullAdress; } public void
	 * setDestinationFullAdress(String destinationFullAdress) {
	 * this.destinationFullAdress = destinationFullAdress; } public Double
	 * getDestinationLattitude() { return destinationLattitude; } public void
	 * setDestinationLattitude(Double destinationLattitude) {
	 * this.destinationLattitude = destinationLattitude; } public Double
	 * getDestinationLongitude() { return destinationLongitude; } public void
	 * setDestinationLongitude(Double destinationLongitude) {
	 * this.destinationLongitude = destinationLongitude; } public int
	 * getWeight() { return weight; } public void setWeight(int weight) {
	 * this.weight = weight; } public String getDimensions() { return
	 * dimensions; } public void setDimensions(String dimensions) {
	 * this.dimensions = dimensions; } public boolean getIsFragile() { return
	 * isFragile; } public void setIsFragile(boolean isFragile) { this.isFragile
	 * = isFragile; } public String getSpecialInstruction() { return
	 * specialInstruction; } public void setSpecialInstruction(String
	 * specialInstruction) { this.specialInstruction = specialInstruction; }
	 * public Date getDeliveryDate() { return deliveryDate; } public void
	 * setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }
	 * public Time getDeliveryTime() { return deliveryTime; } public void
	 * setDeliveryTime(Time deliveryTime) { this.deliveryTime = deliveryTime; }
	 * public boolean getIsOpenOrder() { return isOpenOrder; } public void
	 * setIsOpenOrder(boolean isOpenOrder) { this.isOpenOrder = isOpenOrder; }
	 * public Double getCost() { return cost; } public void setCost(Double cost)
	 * { this.cost = cost; } public Date getCreated() { return created; } public
	 * void setCreated(Date created) { this.created = created; } public int
	 * getRecieverNumver() { return recieverNumver; } public void
	 * setRecieverNumver(int recieverNumver) { this.recieverNumver =
	 * recieverNumver; } public int getSecurityCode() { return securityCode; }
	 * public void setSecurityCode(int securityCode) { this.securityCode =
	 * securityCode; }
	 */
}
