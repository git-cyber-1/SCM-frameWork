package practiceTestFromTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.generic.BaseTest.SimpleBaseClass;

public class SampleInvoiceTestwithRetryAnalyzer extends SimpleBaseClass {

	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListImp.class)
	public void createInvoiceTest() {
		System.out.println("execute invoice test");
		String var = driver.getTitle();
		System.out.println(var);
		Assert.assertEquals(var, "login");
	}

	@Test
	public void createInvoiceWithContacts() {
		System.out.println("cretae invoice with contacts");

	}

}
