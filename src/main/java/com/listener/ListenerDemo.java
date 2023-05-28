package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on test start..");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success..");
	}
	@Override
	public void onTestFailure(ITestResult result) {
        System.out.println("Test is failed...");		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On test failed but within suceess percentage");
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start...");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish...");
	}
}
