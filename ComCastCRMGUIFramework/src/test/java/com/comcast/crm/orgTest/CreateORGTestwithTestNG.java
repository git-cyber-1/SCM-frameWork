package com.comcast.crm.orgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectRepository.CreateNewOrganizationsPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.OrganizationInfoPage;
import com.comcast.crm.ObjectRepository.OrganizationsPage;
import com.comcast.crm.generic.BaseTest.BaseClass;
import com.comcast.crm.generic.webDriverUtility.UtilityClassObject;
//@Listeners(com.comcast.crm.listenerUtility.ListnerImpClass.class)
public class CreateORGTestwithTestNG extends BaseClass {
	@Test(groups = "SmokeTest")
	public void createorg() throws IOException, InterruptedException {
       UtilityClassObject.getTest().log(Status.INFO, "read data from excell");
		String orgname = elib.getDataFromExcel("org", 1, 2); //+ jlib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to orgpage");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to createorgpage");
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create new org");
		CreateNewOrganizationsPage orgpage = new CreateNewOrganizationsPage(driver);
		orgpage.createOrg(orgname);
		 UtilityClassObject.getTest().log(Status.INFO, orgname+"org created");

		OrganizationInfoPage oinfo = new OrganizationInfoPage(driver);
		String actOrgName = oinfo.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgname));
		

	}

	@Test(groups = "RegressionTest")
	public void createOrgWithphNO() throws EncryptedDocumentException, IOException {
		String orgname = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String phonenumber = elib.getDataFromExcel("org", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage opage = new OrganizationsPage(driver);
		opage.getCreateNewOrgBtn().click();

		CreateNewOrganizationsPage copage = new CreateNewOrganizationsPage(driver);
		copage.createOrgwithMobNum(orgname, phonenumber);

		OrganizationInfoPage oipage = new OrganizationInfoPage(driver);
		String actOrgName = oipage.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgname));
		String actphno = oipage.getMobNum().getText();
		Assert.assertEquals(actphno, phonenumber);
		

	}

	@Test(groups = "RegressionTest")
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException {
		String orgname = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage opage = new OrganizationsPage(driver);
		opage.getCreateNewOrgBtn().click();

		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.createOrg(orgname, industry);

		OrganizationInfoPage oipage = new OrganizationInfoPage(driver);
		String actOrgName = oipage.getHeaderMsg().getText();
		Assert.assertEquals(true,actOrgName.contains(orgname));
		String actindustry = oipage.getIndustry().getText();
		Assert.assertEquals(actindustry, industry);
	
	
	}


}
