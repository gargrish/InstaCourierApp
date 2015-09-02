package pojos;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@SuppressWarnings("serial")
public class Package implements Serializable{
	
	private int id; // unique id for each package - will help us to track.
	private User user;
	private String sourceFullAdress;
	private double sourceLattitude;
	private double sourceLongitude;
	private String destinationFullAdress;
	private double destinationLattitude;
	private double destinationLongitude;
	private int weight;
	private String dimensions;
	private boolean isFragile;
	private String specialInstruction;
	private Date deliveryDate;
	private Time deliveryTime;
	private boolean isOpenOrder;
	private double cost;
	private Date created;
	private int recieverNumver;
	private int securityCode;
	//private boolean hasSecurityCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSourceFullAdress() {
		return sourceFullAdress;
	}
	public void setSourceFullAdress(String sourceFullAdress) {
		this.sourceFullAdress = sourceFullAdress;
	}
	public double getSourceLattitude() {
		return sourceLattitude;
	}
	public void setSourceLattitude(double sourceLattitude) {
		this.sourceLattitude = sourceLattitude;
	}
	public double getSourceLongitude() {
		return sourceLongitude;
	}
	public void setSourceLongitude(double sourceLongitude) {
		this.sourceLongitude = sourceLongitude;
	}
	public String getDestinationFullAdress() {
		return destinationFullAdress;
	}
	public void setDestinationFullAdress(String destinationFullAdress) {
		this.destinationFullAdress = destinationFullAdress;
	}
	public double getDestinationLattitude() {
		return destinationLattitude;
	}
	public void setDestinationLattitude(double destinationLattitude) {
		this.destinationLattitude = destinationLattitude;
	}
	public double getDestinationLongitude() {
		return destinationLongitude;
	}
	public void setDestinationLongitude(double destinationLongitude) {
		this.destinationLongitude = destinationLongitude;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public boolean isFragile() {
		return isFragile;
	}
	public void setFragile(boolean isFragile) {
		this.isFragile = isFragile;
	}
	public String getSpecialInstruction() {
		return specialInstruction;
	}
	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Time getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Time deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public boolean isOpenOrder() {
		return isOpenOrder;
	}
	public void setOpenOrder(boolean isOpenOrder) {
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
	public int getRecieverNumver() {
		return recieverNumver;
	}
	public void setRecieverNumver(int recieverNumver) {
		this.recieverNumver = recieverNumver;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	
}
