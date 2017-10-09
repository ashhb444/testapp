package com.examination.dataaccess.dao;

import java.io.Serializable;
import java.util.List;

import com.examination.dataaccess.exception.DataAccessException;

public interface ICrudDAO {

  /**
   * This Method will save the serialiazble object passed to it in the DB.
   * 
   * @param serializableObject
   * @return DomainObject - the object passed with the Id inserted.
   */
  public <DomainObject extends Serializable> DomainObject create (final DomainObject serializableObject)
           throws DataAccessException;

  public <DomainObject extends Serializable> void createAll (final List<DomainObject> serializableObjects)
           throws DataAccessException;

  /**
   * Saves all the objects in the list by using saveOrUpdateAll method on hibernate template
   * 
   * @param <DomainObject>
   * @param serializableObjects
   * @throws DataAccessException
   */

  public <DomainObject extends Serializable> void saveOrUpdate (final DomainObject serializableObject)
           throws DataAccessException;

  /**
   * This Method will delete the serialiazble object passed to it in the DB.
   * 
   * @param serializableObject
   */
  public <DomainObject extends Serializable> void delete (final DomainObject serializableObject)
           throws DataAccessException;

  public <DomainObject extends Serializable> void deleteAll (final List<DomainObject> serializableObjects)
           throws DataAccessException;

  /**
   * This Method will update the serialiazble object passed to it in the DB.
   * 
   * @param serializableObject
   */
  public <DomainObject extends Serializable> void update (final DomainObject serializableObject)
           throws DataAccessException;

  public <DomainObject extends Serializable> void updateAll (final List<DomainObject> serializableObjects)
           throws DataAccessException;

  /**
   * Generic method to get the object by id. Object should have an id column named as id. A Crude implementation -
   * Revise it
   * 
   * @param id -
   *           Long value of the id field
   * @param clazz -
   *           class of the Object that implements serializable
   * @return
   * @throws DataAccessException
   */
  public <DomainObject extends Serializable> DomainObject getById (final Long id, final Class<DomainObject> clazz)
           throws DataAccessException;

  // TODO -RG- Refine the implementation of getById method

  public List<? extends Serializable> getByIds (final List<Long> ids, final Class<?> clazz) throws DataAccessException;

}
