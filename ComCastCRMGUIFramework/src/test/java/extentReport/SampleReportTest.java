package extentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {

	@Test
	public void createContact(){
		
		//spark report config
		ExtentSparkReporter esr=new ExtentSparkReporter("./AdvanceReport/report.html");
		esr.config().setDocumentTitle("CRM Test Suite Results");
		esr.config().setReportName("CRM report");
		esr.config().setTheme(Theme.DARK);
		
		//add environment information and create test
		ExtentReports er=new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("OS","Windows-10");
		er.setSystemInfo("Browser","chrome");
		ExtentTest test = er.createTest("createcontacttest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact creatd");
		}
		else {
			test.log(Status.FAIL,"not created");
		}
		er.flush();
		System.out.println("login to app");
		
		
		
		
	}
	
	
}
