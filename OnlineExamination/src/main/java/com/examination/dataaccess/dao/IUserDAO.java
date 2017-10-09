package com.examination.dataaccess.dao;

import java.util.List;

import com.examination.core.common.bean.User;
import com.examination.dataaccess.exception.DataAccessException;

public interface IUserDAO extends ICrudDAO {

	public User login(String userName, String password) throws DataAccessException;
	public void saveUser(User user) throws DataAccessException;
	public void deleteUser(User user) throws DataAccessException;
	public void updateUser(User user) throws DataAccessException;
	public User getUserById(Long id) throws DataAccessException;
	public List<User> getAllUsers() throws DataAccessException;
	public User getUserByEmail(String email) throws DataAccessException;
}
