package com.examination.dataaccess.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.examination.core.common.bean.User;
import com.examination.dataaccess.dao.IUserDAO;
import com.examination.dataaccess.exception.DataAccessException;

public class UserDAOImpl extends CrudDAOImpl implements IUserDAO{

	public User login(String email, String password) throws DataAccessException {
		
		User user=null;
		Query query = getSessionFactory().
			      getCurrentSession().
			      getNamedQuery("QUERY_GET_USER_BY_EMAIL_AND_PASSWORD");
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    if(query.list().size()>0){
	    	user=(User) query.list().get(0);
	    }
	    return user; 
	}
	
	public void saveUser(User user) throws DataAccessException {
		create(user);
	}

	public void deleteUser(User user) throws DataAccessException {
		delete(user);
	}

	public void updateUser(User user) throws DataAccessException {
		update(user);
	}

	public User getUserById(Long id) throws DataAccessException {
		return getById(id,User.class);
	}

	public List<User> getAllUsers() throws DataAccessException {
		return getList(User.class);
	}

	@Override
	public User getUserByEmail(String email) throws DataAccessException {
		
		User user=null;
		Query query = getSessionFactory().
			      getCurrentSession().
			      getNamedQuery("QUERY_GET_USER_BY_EMAIL");
	    query.setParameter("email", email);
	    if(query.list().size()>0){
	    	user=(User) query.list().get(0);
	    }
	    return user; 
	}
}
