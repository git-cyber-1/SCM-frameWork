package extentReport;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTestwithcongigannotation {

	public ExtentReports er;

	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter esr = new ExtentSparkReporter("./AdvanceReport/report.html");
		esr.config().setDocumentTitle("CRM Test Suite Results");
		esr.config().setReportName("CRM report");
		esr.config().setTheme(Theme.DARK);
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("OS", "Windows-10");
		er.setSystemInfo("Browser", "chrome");
	}

	@AfterSuite
	public void configAS() {
		er.flush();

	}

	@Test
	public void createContact() {
		ExtentTest test = er.createTest("createcontacttest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact creatd");
		} else {
			test.log(Status.FAIL, "not created");
		}
		System.out.println("login to app");

	}
	
	@Test
	public void createcontactwithorg() {
		ExtentTest test = er.createTest("createcontacttest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact creatd");
		} else {
			test.log(Status.FAIL, "not created");
		}
		System.out.println("login to app");

		
	}
	
	@Test
	public void createcontactwithphnum() {
		ExtentTest test = er.createTest("createcontacttest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact creatd");
		} else {
			test.log(Status.FAIL, "not created");
		}
		System.out.println("login to app");

	}

}
