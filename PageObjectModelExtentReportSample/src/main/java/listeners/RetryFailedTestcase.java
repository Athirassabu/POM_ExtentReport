package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public  class RetryFailedTestcase implements IRetryAnalyzer {
	int maxCount=3;
	int retryCount=0;
	
	 public boolean retry(ITestResult result)
	 {
		 if(!result.isSuccess()&& retryCount< maxCount)
		 {
			 retryCount++;
			 return true;
			 
		 }
		return false;
		 
	 }

}
