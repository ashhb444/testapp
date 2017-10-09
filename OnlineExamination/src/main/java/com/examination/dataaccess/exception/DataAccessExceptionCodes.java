package com.examination.dataaccess.exception;

public interface DataAccessExceptionCodes {
	
	int DDL_EXECUTION_FAILED  		= 	1000;
	int USER_AUTHENTICATION_FAILED  = 	1001;
	int RECORD_ALREADY_EXIST  		= 	1002;
	int FILE_UPLOADING_FAILED  		= 	1003;
	int ILLEGAL_INDEX_OPERATION  	= 	1004;
	int PASSWORD_MATCHING_FAILED  	= 	1005;
	int FILE_NOT_FOUND  			= 	1006;
	int FILE_NAME_ALREADY_EXIST  	= 	1007;
}
