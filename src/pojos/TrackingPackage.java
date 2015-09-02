package pojos;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TrackingPackage implements Serializable{

	private String id;
	private Package pack;
	private int status;
	private Date updated;
	private String comments;
	private User deliveryUser;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Package getPack() {
		return pack;
	}
	public void setPack(Package pack) {
		this.pack = pack;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public User getDeliveryUser() {
		return deliveryUser;
	}
	public void setDeliveryUser(User deliveryUser) {
		this.deliveryUser = deliveryUser;
	}
	
	
}
