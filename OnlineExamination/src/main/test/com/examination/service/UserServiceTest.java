package com.examination.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.examination.core.common.bean.User;
import com.examination.core.common.type.StatusType;
import com.examination.service.exception.ServiceException;

public class UserServiceTest extends ServiceBaseTest {

	@BeforeClass
	public static void setUp() {
		baseSetup();
	}
	
	//@Test
	public void testSaveUser(){
		
		User user = new User();
		user.setFirstName("test1");
		user.setLastName("user2");
		user.setEmail("test4");
		
		String password="973d98ac221d7e433fd7c417aa41027a";
		
		password = org.springframework.util.DigestUtils.md5DigestAsHex(password.getBytes());
		System.out.println(password);
		
		user.setPassword("test5");
		user.setImagePath("test6");
		user.setMobileNumber("1234567890");
		user.setStatus(StatusType.ACTIVE);
//		try{
//			getUserService().saveUser(user);
//		}catch(ServiceException e){
//			System.out.println(e);
//		}
	}

	@Test
	public void testLogin() {
		try {
			User user = getUserService().login("ashb4444@gmail.com", "test@123");
			if (user!=null){
				System.out.println(user.getUserType());
			}
			else{
				System.out.println("No user found!");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}


	//@Test
//	public void testDeleteTopic() {
//		try {
//			Topic topic=getTopicService().getTopicById(1L);
//			getTopicService().deleteTopic(topic);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
//	
	//@Test
//	public void testGetQuestions() {
//		try {
//			List<Subject> q=getSubjectService().getSubjectsByQuestion();
//			System.out.println(q.get(0).getName());
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	@Test
//	public void testGetQuestionsBySubject() {
//		try {
//			Subject subject=getSubjectService().getSubjectById(2l);
//			getQuestionService().getQuestionsBySubject(subject);
//			
//		} catch (ServiceException e) {
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
	
	//@Test
//	public void testSaveExam() {
//		try {
//			SubTopicQuestionMapping sqm1 = new SubTopicQuestionMapping();
//			SubTopicQuestionMapping sqm2 = new SubTopicQuestionMapping();
//			sqm1.setSubTopicId(1l);
//			sqm1.setQuestions(5l);
//			sqm2.setSubTopicId(5l);
//			sqm2.setQuestions(2l);
//			UserGroup ug1= getUserGroupService().getUserGroupById(1L);
//			//UserGroup ug2= getUserGroupService().getUserGroupById(2L);
//			Set<UserGroup> set=new HashSet<UserGroup>();
//			set.add(ug1);
//			//set.add(ug2);
//			Set<SubTopicQuestionMapping> sTQMset=new HashSet<SubTopicQuestionMapping>();
//			sTQMset.add(sqm1);
//			sTQMset.add(sqm2);
//			Exam exam= new Exam();
//			exam.setUserGroups(set);
//			exam.setSubTopicQuestionMappings(sTQMset);
//			getExamService().saveExam(exam);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
	
	//@Test
//	public void testGetExam() {
//		try {
//			Exam exam = getExamService().getExamById(3L);
//			System.out.println(exam.getName()+"--"+exam.getDuration()+"--"+exam.getStartDate());
//			Set<SubTopicQuestionMapping> mappings= exam.getSubTopicQuestionMappings();
//			
//			SubTopic subTopic =null;
//			for(SubTopicQuestionMapping mapping:mappings){
//				System.out.println(mapping.getSubTopicId() +"--" + mapping.getQuestions());
//				long questionCount=mapping.getQuestions();
//				subTopic = getSubTopicService().getSubTopicById(mapping.getSubTopicId());
//				Set<Question> question = subTopic.getQuestions();
//				List<Question> list = new ArrayList<Question>(question);
//				
//				if(questionCount == list.size()){
//					for(Question q:list){
//						System.out.println(q.getQuestion());
//					}
//				} else{
//					
//					for(long i=questionCount;i<list.size();i++){
//						Collections.shuffle(list);
//						System.out.println(list.get((int)i).getQuestion());
//					}
//				}
//			}
//
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	//@Test
//	public void testGetTopic() {
//		try {
//			Topic topic = getTopicService().getTopicById(12L);
//			
//			for(SubTopic st: topic.getSubTopics()){
//				System.out.println(st.getName());
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	//@Test
//	public void testCreateSubTopic() {
//		try {
//			SubTopic subTopic=new SubTopic();
//			Topic topic = getTopicService().getTopicById(20L);
//			subTopic.setName("xyz");
//			subTopic.setTopic(topic);
//			subTopic.setStatus(StatusType.ACTIVE);
//			getSubTopicService().saveSubTopic(subTopic);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	//@Test
//	public void testDeleteSubTopic() {
//		try {
//			SubTopic subTopic=getSubTopicService().getSubTopicById(15L);
//			getSubTopicService().deleteSubTopic(subTopic);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	//@Test
//	public void testConcept() throws ParseException{
//		String x="1";
//		String y="1";
//		System.out.println(x.equals(y));
//	}
//	
//	//@Test
//	public void saveUserExamResult() throws ServiceException{
//		
//		UserExamResult userExamResult = new UserExamResult();
//		User user = getUserService().getUserById(2l);
//		Exam exam = getExamService().getExamById(3l);
//		userExamResult.setUser(user);
//		userExamResult.setExam(exam);
//		userExamResult.setCorrectAnswers(3);
//		getUserExamResultService().saveUserExamResult(userExamResult);
//	}
	
	@AfterClass
	public static void tearDown() {
		baseTeardown();
	}
}
