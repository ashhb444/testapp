package com.examination.dataaccess.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.examination.core.common.bean.User;
import com.examination.core.common.type.StatusType;
import com.examination.dataaccess.exception.DataAccessException;

public class UserDAOTest extends DataAccessBaseTest {

	@BeforeClass
	public static void setUp() {
		baseSetup();
	}
	
	//@Test
	public void testSaveUser(){
		
		User user = new User();
		user.setFirstName("test");
		user.setLastName("user");
		user.setEmail("test");
		user.setPassword("test");
		user.setImagePath("test");
		user.setMobileNumber("1234567890");
		user.setStatus(StatusType.ACTIVE);
		try{
			getUserDAO().create(user);
		}catch(DataAccessException e){
			System.out.println(e);
		}
		
	}

	//@Test
	public void testLogin() {
		try {
			User user = getUserDAO().login("test", "test");
			System.out.println(user.getUserType());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testRandomQuestion() {
//		try {
//			Question question = getQuestionDAO().getRandomQuestion(1);
//			System.out.println(question.getQuestion());
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
//	// @Test
//	public void testgetExistingUsers() {
//		try {
//			List<User> users = getUserDAO().getAllExistingUsers(UserType.AGENT);
//			System.out.println(users.get(1).getUserName());
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// @Test
//	public void testgetUserById() {
//		try {
//			User user = getUserDAO().getUserById(2L);
//			System.out.println(user.getUserName());
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
//	}
//
//	//@Test
//	public void testUpdateUser() {
//		try {
//			getUserDAO().updateUser(1l, "test", "54545", "test addr","","");
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetUserByContactNo() {
//		try {
//			User user=getUserDAO().getUserByContactNumber("1234567890");
//			System.out.println(user.getUserName());
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
//	}

	@AfterClass
	public static void tearDown() {
		baseTeardown();
	}
}
