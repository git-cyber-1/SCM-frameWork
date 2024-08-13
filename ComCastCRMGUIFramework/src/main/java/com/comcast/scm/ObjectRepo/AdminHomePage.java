package com.comcast.scm.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;

public class AdminHomePage extends WebDriverUtility {

	public WebDriver driver;

	@FindAll({ @FindBy(xpath = "//a[text()='Add Manufacturer']"),
			@FindBy(xpath = "//a[@href=/admin/add_manufacturer.php]") })
	private WebElement addMaucaturer;

	@FindAll({@FindBy(xpath="//input[@type='button']"),@FindBy(xpath="//input[@value='Log out']")})
	private WebElement SignOut;

	@FindBy(id = "manufacturer:name")
	private WebElement ManufacName;

	@FindBy(xpath = "//option[text()='BTS (BASTA)']")
	private WebElement dropdownOption;

	@FindBy(id = "manufacturer:email")
	private WebElement ManufacEmail;

	@FindBy(id = "manufacturer:phone")
	private WebElement ManufacPhone;

	@FindBy(id = "manufacturer:username")
	private WebElement ManufacUN;

	@FindBy(id = "manufacturer:password")
	private WebElement ManufacPW;

	@FindBy(xpath = "//input[@value='Add Manufacturer']")
	private WebElement AddManufacBtn;

	@FindBy(xpath = "//body//tr//td")
	private List<WebElement> allrows;

	@FindBy(xpath = "//h1[text()='Welcome Admin']")
	private WebElement Welcomemsg;

	@FindBy(xpath = "//h1[text()='Add Manufacturer']")
	private WebElement ManufactuererMsgInAdminPage;

	@FindAll({ @FindBy(xpath = "//a[text()='Add Retailers']"),
			@FindBy(xpath = "//a[@href='../admin/add_product.php']") })
	private WebElement AddRetailer;

	@FindAll({ @FindBy(id = "retailer:username"), @FindBy(name = "txtRetailerUname"),
			@FindBy(xpath = "//input[@placeholder='Username']") })
	private WebElement retailerUname;

	@FindAll({ @FindBy(id = "retailer:password"), @FindBy(name = "txtRetailerPassword"),
			@FindBy(xpath = "//input[@placeholder='password']") })
	private WebElement retailerPassword;

	@FindAll({ @FindBy(id = "retailer:phone"), @FindBy(name = "txtRetailerPhone"),
			@FindBy(xpath = "//input[@placeholder='phone']") })
	private WebElement retailerPhone;

	@FindAll({ @FindBy(id = "retailer:email"), @FindBy(name = "txtRetailerEmail"),
			@FindBy(xpath = "//input[@placeholder='Email']") })
	private WebElement retailerEmail;

	@FindAll({ @FindBy(id = "retailer:address"), @FindBy(name = "txtRetailerAddress"),
			@FindBy(xpath = "//input[@placeholder='Address']") })
	private WebElement retailerAddres;

	@FindAll({ @FindBy(xpath = "//input[@value='Add Retailer']"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement ClickAddRetailerButton;

	@FindAll({ @FindBy(id = "retailer:areaCode"), @FindBy(name = "cmbAreaCode") })
	private WebElement retailerDropDown;

	@FindBy(xpath = "//h1[text()='Add Retailer']")
	private WebElement RetailerWelcomeMsg;

	@FindAll({@FindBy(xpath="//a[text()='Add Distributor']"),@FindBy(xpath="//a[@href='../admin/add_distributor.php']")})
	private WebElement addDistributorBtn;
	
	@FindAll({ @FindBy(id = "distributor:name"), @FindBy(name = "txtDistributorName"),
		@FindBy(xpath = "//input[@placeholder='Name']") })
          private WebElement distributorName;
	
	@FindAll({ @FindBy(id = "distributor:email"), @FindBy(name = "txtDistributorEmail"),
		@FindBy(xpath = "//input[@placeholder='Email']") })
         private WebElement distributorEmail;
	
	@FindAll({ @FindBy(id = "distributor:phone"), @FindBy(name = "txtDistributorPhone"),
		@FindBy(xpath = "//input[@placeholder='Phone']") })
        private WebElement distributorPhone;

	@FindAll({ @FindBy(id = "distributor:address"), @FindBy(name = "txtDistributorAddress"),
		@FindBy(xpath = "//input[@placeholder='Address']") })
          private WebElement distributorAddres;
	
	@FindBy(xpath="//input[@value='Add Distributor']")
	private WebElement submitDistributorBtn;
	
	@FindBy(xpath="//h1[text()='Add Distributor']")
	private WebElement distributorWelcomMsg;
	
	@FindBy(xpath="//span[contains(text(),'* 5-14 characters, Only Alp')]")
	private WebElement errorMsg;
	
	@FindBy(xpath="//span[@class='error_message']")
	private WebElement emptyErroMsg;
	
	@FindBy(xpath="//a[text()='Orders']")
	private WebElement ordersBtn;
	
	@FindBy(id="cmbFilter")
	private WebElement orderDrpDown;
	
	@FindBy(xpath="//option[@value='id']")
	private WebElement selectedOptionId;
	
	@FindBy(id="txtId")
	private WebElement orderIdTextBox;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement AdminProductssBtn;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement viewProductsCheckBox;
	
	@FindBy(xpath="//input[@name='chkId[]']")
	private WebElement listOfCheckBox;
	
	@FindBy(xpath="//input[@name='rdbStock' and @value='1']")
	private WebElement addProductRadioBtn;
	
	@FindBy(xpath="//a[text()='Add Products']")
	private WebElement addProductsBtn;
	
	@FindBy(xpath="//table/tbody/tr/td[3]")
	private List< WebElement> productListAdminPage;
	
	@FindBy(xpath="//a[text()='Retailers']")
	private WebElement AdminRetailer;
	
	@FindBy(xpath="//table/tbody/tr/td[3]")
	private List<WebElement> RetailerListAdminPage;
	
	@FindBy(xpath="//a[text()='Distributors']")
	private WebElement distributorListBtn;
	
	public WebElement getDistributorListBtn() {
		return distributorListBtn;
	}

	public List<WebElement> getRetailerListAdminPage() {
		return RetailerListAdminPage;
	}

	public WebElement getAdminRetailer() {
		return AdminRetailer;
	}

	public List<WebElement> getProductListAdminPage() {
		return productListAdminPage;
	}

	public WebElement getAddProductsBtn() {
		return addProductsBtn;
	}

	public WebElement getAddProductRadioBtn() {
		return addProductRadioBtn;
	}

	public WebElement getListOfCheckBox() {
		return listOfCheckBox;
	}

	public WebElement getAdminProductssBtn() {
		return AdminProductssBtn;
	}

	public WebElement getViewProductsCheckBox() {
		return viewProductsCheckBox;
	}

	public WebElement getOrderIdTextBox() {
		return orderIdTextBox;
	}

	public WebElement getOrdersBtn() {
		return ordersBtn;
	}

	public WebElement getOrderDrpDown() {
		return orderDrpDown;
	}

	public WebElement getSelectedOptionId() {
		return selectedOptionId;
	}

	public WebElement getEmptyErroMsg() {
		return emptyErroMsg;
	}

	public WebElement getDropdownOption() {
		return dropdownOption;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getAddDistributorBtn() {
		return addDistributorBtn;
	}

	public WebElement getDistributorName() {
		return distributorName;
	}

	public WebElement getDistributorEmail() {
		return distributorEmail;
	}

	public WebElement getDistributorPhone() {
		return distributorPhone;
	}

	public WebElement getDistributorAddres() {
		return distributorAddres;
	}

	public WebElement getSubmitDistributorBtn() {
		return submitDistributorBtn;
	}

	public WebElement getDistributorWelcomMsg() {
		return distributorWelcomMsg;
	}

	public WebElement getClickAddRetailerButton() {
		return ClickAddRetailerButton;
	}

	public WebElement getRetailerWelcomeMsg() {
		return RetailerWelcomeMsg;
	}

	public WebElement getRetailerDropDown() {
		return retailerDropDown;
	}

	public WebElement getClickAddRetailer() {
		return ClickAddRetailerButton;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddRetailer() {
		return AddRetailer;
	}

	public WebElement getRetailerUname() {
		return retailerUname;
	}

	public WebElement getRetailerPassword() {
		return retailerPassword;
	}

	public WebElement getRetailerPhone() {
		return retailerPhone;
	}

	public WebElement getRetailerEmail() {
		return retailerEmail;
	}

	public WebElement getRetailerAddres() {
		return retailerAddres;
	}

	public WebElement getManufactuererMsgInAdminPage() {
		return ManufactuererMsgInAdminPage;
	}

	public WebElement getWelcomemsg() {
		return Welcomemsg;
	}

	public void setWelcomemsg(WebElement welcomemsg) {
		Welcomemsg = welcomemsg;
	}

	public List<WebElement> getAllrows() {
		return allrows;
	}

	public WebElement getAddManufacBtn() {
		return AddManufacBtn;
	}

	public WebElement getManufacName() {
		return ManufacName;
	}

	public WebElement getManufacEmail() {
		return ManufacEmail;
	}

	public WebElement getManufacPhone() {
		return ManufacPhone;
	}

	public WebElement getManufacUN() {
		return ManufacUN;
	}

	public WebElement getManufacPW() {
		return ManufacPW;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	public WebElement getAddMaucaturer() {
		return addMaucaturer;
	}

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void signout() {
		SignOut.click();
	}

	public void addManufacturer(String name, String email, String Mnum, String un, String pw) {
		addMaucaturer.click();
		ManufacName.sendKeys(name);
		ManufacEmail.sendKeys(email);
		ManufacPhone.sendKeys(Mnum);
		ManufacUN.sendKeys(un);
		ManufacPW.sendKeys(pw);
		AddManufacBtn.click();

	}

	public void addRetailer(String username, String password, String phone, String email, String address)
			throws InterruptedException {
		AddRetailer.click();
		retailerUname.sendKeys(username);
		retailerPassword.sendKeys(password);
        select(retailerDropDown, "SRKJ (Sarkhej)");
        retailerEmail.sendKeys(email);
        retailerAddres.sendKeys(address);
		retailerPhone.sendKeys(phone);
        ClickAddRetailerButton.click();
	}
	public void addDistributor(String Name,String Email,String phone,String address)
	{
		addDistributorBtn.click();
		distributorName.sendKeys(Name);
		distributorEmail.sendKeys(Email);
		distributorPhone.sendKeys(phone);
		distributorAddres.sendKeys(address);
		submitDistributorBtn.click();
	}
	
}