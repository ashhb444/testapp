package com.examination.service;

import java.util.List;

import com.examination.core.common.bean.User;
import com.examination.service.exception.ServiceException;

public interface IUserService{

	public User login(String userName, String password) throws ServiceException;
	public void saveUser(User user) throws ServiceException;
	public void deleteUser(User user) throws ServiceException;
	public void updateUser(User user) throws ServiceException;
	public User getUserById(Long id) throws ServiceException;
	public List<User> getAllUsers() throws ServiceException;
	public User getUserByEmail(String email) throws ServiceException;
}
