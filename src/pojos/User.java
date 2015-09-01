package pojos;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{
private String id;
private String name;
private String email;
private String contact;
private boolean isMobileVerified;
private boolean isEmailVerified;
private boolean isActive;
private Timestamp registerDate;
private Timestamp modifyDate;
private Address address;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public boolean isMobileVerified() {
	return isMobileVerified;
}
public void setMobileVerified(boolean isMobileVerified) {
	this.isMobileVerified = isMobileVerified;
}
public boolean isEmailVerified() {
	return isEmailVerified;
}
public void setEmailVerified(boolean isEmailVerified) {
	this.isEmailVerified = isEmailVerified;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public Timestamp getRegisterDate() {
	return registerDate;
}
public void setRegisterDate(Timestamp registerDate) {
	this.registerDate = registerDate;
}
public Timestamp getModifyDate() {
	return modifyDate;
}
public void setModifyDate(Timestamp modifyDate) {
	this.modifyDate = modifyDate;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}



}
