package com.comcast.crm.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.BaseTest.BaseClass;
import com.comcast.crm.generic.webDriverUtility.UtilityClassObject;

public class ListnerImpClass implements ITestListener, ISuiteListener {

	public ExtentReports er;
	public ExtentSparkReporter esr;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		String Time = new Date().toString().replace(" ", "_").replace(":", "_");
		esr = new ExtentSparkReporter("./AdvanceReport/report_.html"+Time);
		esr.config().setDocumentTitle("CRM Test Suite Results");
		esr.config().setReportName("CRM report");
		esr.config().setTheme(Theme.DARK);
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("OS", "Windows-10");
		er.setSystemInfo("Browser", "chrome");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		er.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = er.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "<<<STARTED>>>");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		// EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass.ldriver);
		// File src = ts.getScreenshotAs(OutputType.FILE);
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String Time = new Date().toString().replace(" ", "_").replace(":", "_");
		// try {
		// FileUtils.copyFile(src, new File("./ScreenShot/" + testName + "+" + Time +
		// ".png"));
		// } catch (IOException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		test.addScreenCaptureFromBase64String(src, testName + "_" + Time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "<<<<FAILED>>>>");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO, result.getMethod().getMethodName() + "<<<<SKIPPED>>>>");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO, result.getMethod().getMethodName() + "<<<<COMPLETED>>>>");

	}

}
