package codingStandard;

import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.generic.BaseTest.SimpleBaseClass;

/**
 * test class for contact module 
 * @author girija
 * 
 */

public class SearchContactTest extends SimpleBaseClass{
	/**
	 * scenario: login()==>>navigateContact==>>>Createcontact()==>>verify
	 */

	@Test
	public void searchContactTest() {
		/* step-1: login to app */
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(null, null, null);
	}
}
