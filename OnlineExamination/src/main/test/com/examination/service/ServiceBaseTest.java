package com.examination.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceBaseTest {

	public static ApplicationContext serviceContext;

	public static void baseSetup()
	{
		serviceContext = new ClassPathXmlApplicationContext(new String[] {

				"/com/examination/spring/spring-hibernate.xml",
				"/com/examination/spring/spring-hibernate-param.xml",
				"/com/examination/spring/examination-services.xml",
				"/com/examination/spring/examination-dataaccess.xml",
		 });
	}
	
	public static void baseTeardown() {

	}
	
	public static ApplicationContext getDataAccessContext() {
		return serviceContext;
	}
	
	public IUserService getUserService()
	{
		return (IUserService)serviceContext.getBean("userService");
	}
}
