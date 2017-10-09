package com.examination.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.examination.core.common.bean.User;
import com.examination.core.common.type.StatusType;
import com.examination.core.common.type.UserType;
import com.examination.service.IUserService;
import com.examination.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private IUserService userService;
	private User user;
	private Map<String, Object> sessionMap;
	private final static Logger logger = Logger.getLogger(UserLoginAction.class);
	
	private static final String ADMINSUCCESS = "adminsuccess";
	private static final String EXAMINORSUCCESS = "agentsuccess";
	private static final String EXAMINEESUCCESS = "examineesuccess";

    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
	
	public String login(){
		
		String result=ERROR;
		try {
			user = getUserService().login(getEmail(),
					getPassword());
			
			if (user != null) {
				if(user.getStatus()==StatusType.ACTIVE){
					if (UserType.ADMIN.equals(user.getUserType())) {
						logger.info("This is info : " );
						sessionMap.put("user", user);
						result=ADMINSUCCESS;
					} else if (UserType.EXAMINEE.equals(user.getUserType())) {
						sessionMap.put("user", user);
						result=EXAMINEESUCCESS;
					} else if (UserType.EXAMINOR.equals(user.getUserType())) {
						sessionMap.put("user", user);
						result=EXAMINORSUCCESS;
					}

				} else{
					addActionError("Your account is inactive.");
					result=ERROR;
				}
			} else {
				addActionError("Invalid Username or Password");
				result=ERROR;
			}
		} catch (ServiceException e) {
			addActionError("Something went wrong, Try later!");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	public String logout() {
        // remove user from the session
        if (sessionMap.containsKey("user")) {
            sessionMap.remove("user");
        }
        return SUCCESS;
    }
	
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
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
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
