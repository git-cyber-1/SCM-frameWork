package com.comcast.scm.listenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListImp implements IRetryAnalyzer{
	
     int count=0;
     int limitcount=5;
	@Override
	public boolean retry(ITestResult result) {
		if(count<limitcount) {
			count++;
			return true;
		}
		return false;
	}

}
