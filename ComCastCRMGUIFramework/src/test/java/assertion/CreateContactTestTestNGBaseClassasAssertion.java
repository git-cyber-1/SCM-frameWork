package assertion;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.ObjectRepository.ContactInfoPage;
import com.comcast.crm.ObjectRepository.ContactPage;
import com.comcast.crm.ObjectRepository.CreateContactPage;
import com.comcast.crm.ObjectRepository.CreateNewOrganizationsPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.OrgPageFromContact;
import com.comcast.crm.ObjectRepository.OrganizationInfoPage;
import com.comcast.crm.ObjectRepository.OrganizationsPage;
import com.comcast.crm.generic.BaseTest.SimpleBaseClass;

public class CreateContactTestTestNGBaseClassasAssertion extends SimpleBaseClass {
	@Test(groups ="SmokeTest")
	public void createcontact() throws IOException {
		// testScriptData should be in the testScript
		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCrtcontactBtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createcontact(lastname);

		ContactInfoPage cip = new ContactInfoPage(driver);
		String header = cip.getHeaderMsg().getText();
		String actlastname=cip.getCntName().getText();
        System.out.println(header);System.out.println(actlastname);
		boolean status1=header.contains(lastname);
		//Assert.assertEquals(status1,false);
		Assert.assertTrue(false);
		//Assert.assertFalse(true);
		
		boolean status2=actlastname.equals(lastname);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(status2, true);
		

	}

	@Test(groups="RegressionTest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		String orgname = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		String ContactLastname = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.createOrg(orgname);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actheaderMsg = oip.getHeaderMsg().getText();
		
		if (actheaderMsg.contains(orgname)) {
			System.out.println(orgname + " verified>>>>>>>passed");
		} else {
			System.out.println(orgname + " not verified>>>>>>failed");
		}
		String actOrgName = oip.getActOrgName().getText();
		
		if (actOrgName.equals(orgname)) {
			System.out.println(orgname + " verified>>>>>passed");
		} else {
			System.out.println(orgname + " verified>>>>>failed");
		}
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCrtcontactBtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createcontactwithorg(ContactLastname);
		
		OrgPageFromContact opfc = new OrgPageFromContact(driver);
		opfc.searchOrgName(orgname);
		
		ccp.saveBtn();
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actLastname = cip.getHeaderMsg().getText();
		String orgnameincipage=cip.getOrgnameinContactInfo().getText();
		System.out.println(actLastname);System.out.println(orgnameincipage);
		if(actLastname.contains(ContactLastname)) {
			System.out.println(ContactLastname+ " verifed>>>>>>>passed");
		}
		else {
			System.out.println(ContactLastname+ " not verified>>>>>>>failed");
		}
		if(orgnameincipage.equals(orgname)) {
			System.out.println(orgname+ " verified>>>>>>passed");
		}
		else {
			System.out.println(orgname+" not verified>>>>>failed");
		}
		
		

	}

	@Test(groups="RegressionTest")
	public void createContactWithSupportdateTest() throws EncryptedDocumentException, IOException {

		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCrtcontactBtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		String StartDate = jlib.getSysDateYYYYDDMM();
		String EndDate = jlib.getRequiredDate(30);
		ccp.createContactWithSupportDate(lastname, StartDate, EndDate);

		ContactInfoPage cip = new ContactInfoPage(driver);
		String header = cip.getHeaderMsg().getText();
		Assert.assertEquals(header,lastname);
		String actstrtdate = cip.getActStrtDate().getText();
		Assert.assertEquals(actstrtdate.trim(),StartDate);
		
		String actendate = cip.getActEndDATE().getText();
        Assert.assertEquals(actendate.trim(),EndDate);

	}


}
