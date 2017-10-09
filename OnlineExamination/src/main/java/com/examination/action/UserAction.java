package com.examination.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.examination.core.common.bean.User;
import com.examination.core.common.type.StatusType;
import com.examination.core.common.type.UserType;
import com.examination.service.IUserService;
import com.examination.service.exception.ServiceException;
import com.examination.util.EmailUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long userGroupId;
	private User user;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String mobileNumber;
	private String email;
	private String dob;
	private List<User> userList=new ArrayList<User>();
	private StatusType status[];
	private UserType userType[];
	private Map<String,String> jsonObject = new HashMap<String,String>();
	private IUserService userService;
	private static final String ADMIN_DASHBOARD = "admin";
	
	public String dashboard(){
		
		return ADMIN_DASHBOARD;
	}
	
	public String loadUsers(){
		
		String result=ERROR;
		try {
			userList=getUserService().getAllUsers();
			result=SUCCESS;
		} catch (ServiceException e) {
			addActionError("Something went wrong, Try later!");
		} 
		return result;
	}
	
//	public String addUser(){
//		
//		String result=ERROR;
//		try {
//			userType=UserType.values();
//			status=StatusType.values();
//			result=SUCCESS;
//		} catch (ServiceException e) {
//			addActionError("Something went wrong, Try later!");
//			logger.error(e.getMessage(), e);
//		} 
//		return result;
//	}
	
	public String saveUser(){
		
		String result=ERROR;
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobileNumber(mobileNumber);
		user.setDob(dob);
		user.setUserType(userType[0]);
		user.setStatus(status[0]);
		
		if(id==null){
			try {
				User existingUser=getUserService().getUserByEmail(email);
				if(existingUser==null){
					getUserService().saveUser(user);
					EmailUtil.eMailUserCredentials(email, password);
					jsonObject.put("message","User Added Successfully");
					result=SUCCESS;
				} else{
					jsonObject.put("message","Email already exists");
					result=SUCCESS;
				}
			} catch (ServiceException e) {
				jsonObject.put("message","Something went wrong, Try later!");
			} catch (AddressException e) {
				jsonObject.put("message","User is created but unable to send the credentials through email");
			} catch (MessagingException e) {
				jsonObject.put("message","User is created but unable to send the credentials through email");
			}
		} else if(id!=null){
			try {
				user.setId(id);
				getUserService().updateUser(user);
				jsonObject.put("message","User Updated Successfully");
				result=SUCCESS;
			} catch (ServiceException e) {
				jsonObject.put("message","Something went wrong, Try later!");
			}
		}
		return result;
	}
	
	public String deleteUser(){
		
		String result=ERROR;
		try {
			User user = getUserService().getUserById(id);
			getUserService().deleteUser(user);
			jsonObject.put("message","User Deleted Successfully");
			result=SUCCESS;
		} catch (ServiceException e) {
			jsonObject.put("message","Something went wrong, Try later!");
		} 
		return result;
	}
	
	public String editUser(){
		
		String result=ERROR;
		try {
			user=getUserService().getUserById(id);
			userType=UserType.values();
			status=StatusType.values();
			result=SUCCESS;
		} catch (ServiceException e) {
			addActionError("Something went wrong, Try later!");
		}
		return result;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public StatusType[] getStatus() {
		return status;
	}
	public void setStatus(StatusType[] status) {
		this.status = status;
	}
	public UserType[] getUserType() {
		return userType;
	}
	public void setUserType(UserType[] userType) {
		this.userType = userType;
	}
	public Map<String, String> getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(Map<String, String> jsonObject) {
		this.jsonObject = jsonObject;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
