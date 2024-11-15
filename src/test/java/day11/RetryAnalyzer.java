package day11;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 5;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
