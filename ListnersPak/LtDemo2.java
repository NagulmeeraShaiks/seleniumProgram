package ListnersPak;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LtDemo2 implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("test class was finesh ::"+arg0.getName());
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("test class was starting ::"+arg0.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("test class onTestFailedButWithinSuccessPercentage ::"+arg0.getName());
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ontest failure ::"+arg0.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped ::"+arg0.getName());
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("onTestStart ::"+arg0.getName());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("onTestSucessfull ::"+arg0.getName());
		
	}

}
