package com.examination.core.common.bean;

import java.io.Serializable;
import java.util.Set;

import com.examination.core.common.type.StatusType;
import com.examination.core.common.type.UserType;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobileNumber;
	private String dob;
	private String imagePath;
	private String examField;
	private UserType userType;
	private StatusType status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getExamField() {
		return examField;
	}
	public void setExamField(String examField) {
		this.examField = examField;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
}
