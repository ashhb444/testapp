package com.examination.dataaccess.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataAccessBaseTest {

	public static ApplicationContext dataAccessContext;

	public static void baseSetup()
	{
		dataAccessContext = new ClassPathXmlApplicationContext(new String[] {

				"/com/examination/spring/spring-hibernate.xml",
				"/com/examination/spring/spring-hibernate-param.xml",
				"/com/examination/spring/examination-dataaccess.xml",
		 });
	}
	
	public static void baseTeardown() {

	}
	
	public static ApplicationContext getDataAccessContext() {
		return dataAccessContext;
	}
	
	public IUserDAO getUserDAO()
	{
		return (IUserDAO)dataAccessContext.getBean("userDAO");
	}
}
