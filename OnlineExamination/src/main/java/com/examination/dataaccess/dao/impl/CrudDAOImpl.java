package com.examination.dataaccess.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import com.examination.dataaccess.dao.ICrudDAO;
import com.examination.dataaccess.exception.DataAccessException;
import com.examination.dataaccess.exception.DataAccessExceptionCodes;

public class CrudDAOImpl implements ICrudDAO{

	private SessionFactory sessionFactory;
	
	public <DomainObject extends Serializable> DomainObject create(
			DomainObject serializableObject) throws DataAccessException {

		try {
	         getSessionFactory().getCurrentSession().save(serializableObject);
	      } catch (org.springframework.dao.DataAccessException dae) {
	         throw new DataAccessException(DataAccessExceptionCodes.DDL_EXECUTION_FAILED,"Exception while saving the object",dae);
	      }
	      return serializableObject;
	}

	public <DomainObject extends Serializable> void createAll(
			List<DomainObject> serializableObjects) throws DataAccessException {
		try {
			for(DomainObject serializableObject: serializableObjects)
			{
				getSessionFactory().getCurrentSession().save(serializableObject);
			}
		}
		catch(org.springframework.dao.DataAccessException dae)
		{
			throw new DataAccessException(DataAccessExceptionCodes.DDL_EXECUTION_FAILED,"Exception while saving the object",dae);
		}
	}

	public <DomainObject extends Serializable> void saveOrUpdate(
			DomainObject serializableObject) throws DataAccessException {
		try
		{
			getSessionFactory().getCurrentSession().saveOrUpdate(serializableObject);
		}
		catch(org.springframework.dao.DataAccessException dae)
		{
			throw new DataAccessException(DataAccessExceptionCodes.DDL_EXECUTION_FAILED,"Exception while saving/updating the object",dae);
		}
	}

	public <DomainObject extends Serializable> void delete(
			DomainObject serializableObject) throws DataAccessException {
		try {
			getSessionFactory().getCurrentSession().delete(serializableObject);
	      } catch (org.springframework.dao.DataAccessException dae) {
	         throw new DataAccessException(DataAccessExceptionCodes.DDL_EXECUTION_FAILED,"Error while deleting the object", dae);
	      }
	}

	public <DomainObject extends Serializable> void deleteAll(
			List<DomainObject> serializableObjects) throws DataAccessException {
		try {
			for(DomainObject serializableObject: serializableObjects)
			{
				getSessionFactory().getCurrentSession().delete(serializableObject);
			}
		} catch (org.springframework.dao.DataAccessException dae) {
	    	  throw new DataAccessException(DataAccessExceptionCodes.DDL_EXECUTION_FAILED,"Error while deleting the object", dae);
	      }
	}

	public <DomainObject extends Serializable> void update(
			DomainObject serializableObject) throws DataAccessException {
		try {
			getSessionFactory().getCurrentSession().update(serializableObject);
	      } catch (org.springframework.dao.DataAccessException dae) {
	    	  throw new DataAccessException(DataAccessExceptionCodes.DDL_EXECUTION_FAILED,"Error while updating the object", dae);
	      }
	}

	public <DomainObject extends Serializable> void updateAll(
			List<DomainObject> serializableObjects) throws DataAccessException {
		try {
	         for (DomainObject serializableObject : serializableObjects) {
	        	 getSessionFactory().getCurrentSession().update(serializableObject);
	         }
	      } catch (org.springframework.dao.DataAccessException dae) {
	    	  throw new DataAccessException(DataAccessExceptionCodes.DDL_EXECUTION_FAILED,"Error while updating the object", dae);
	      }
	}
	
	@SuppressWarnings ("unchecked")
	public <DomainObject extends Serializable> DomainObject getById(Long id,
			Class<DomainObject> clazz) throws DataAccessException {
		try {
			return (DomainObject) sessionFactory.getCurrentSession().get(clazz, id);
	      } catch (org.springframework.dao.DataAccessException dae) {
	    	  throw new DataAccessException(DataAccessExceptionCodes.DDL_EXECUTION_FAILED,"Error while getting the object", dae);
	      }
	}

	public List<? extends Serializable> getByIds(List<Long> ids, Class<?> clazz)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <DomainObject extends Serializable> List<DomainObject> getList(
			Class<DomainObject> clazz)
			throws DataAccessException {
		
			Criteria criteria = sessionFactory.getCurrentSession().
				      createCriteria(clazz).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); //Distinct to get distinct record, as sometimes duplicate entries come in one to many
			
			return criteria.list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
