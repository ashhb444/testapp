package com.examination.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.examination.core.common.bean.User;
import com.examination.dataaccess.dao.IUserDAO;
import com.examination.dataaccess.exception.DataAccessException;
import com.examination.service.IUserService;
import com.examination.service.exception.ServiceException;

@Transactional
public class UserServiceImpl implements IUserService{

	private IUserDAO userDAO;

	public User login(String userName, String password) throws ServiceException {
		try {
			return getUserDAO().login(userName, password);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("Caught an exception while login", e);
		}
	}
	
	public void saveUser(User user) throws ServiceException {
		
		try {
			getUserDAO().saveUser(user);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("Caught an exception while saving user", e);
		}
	}
	
	public void deleteUser(User user) throws ServiceException {
		
		try {
			getUserDAO().deleteUser(user);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("Caught an exception while saving user", e);
		}
	}
	
	public void updateUser(User user) throws ServiceException {
		
		try {
			getUserDAO().update(user);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("Caught an exception while updating user", e);
		}
	}
	
	public User getUserById(Long id) throws ServiceException {
		
		try {
			return getUserDAO().getUserById(id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("Caught an exception while getting user by id", e);
		}
	}
	
	public List<User> getAllUsers() throws ServiceException {
		
		try {
			return getUserDAO().getAllUsers();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("Caught an exception while getting users", e);
		}
	}
	
	@Override
	public User getUserByEmail(String email) throws ServiceException {
		
		try {
			return getUserDAO().getUserByEmail(email);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new ServiceException("Caught an exception while getting userby email", e);
		}
	}
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
