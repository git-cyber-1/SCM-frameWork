package com.comcast.scm.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;

/**
 * @author girija sankar pom class for manufacturer page
 */
public class ManufacturerPage extends WebDriverUtility {

	public WebDriver driver;

	@FindAll({ @FindBy(xpath = "//a[text()='Add Products']"),
			@FindBy(xpath = "//a[@href='../manufacturer/add_product.php']") })
	private WebElement addProductBtn;

	@FindAll({ @FindBy(id = "product:name"), @FindBy(name = "txtProductName"),
			@FindBy(xpath = "//input[@placeholder='Product Name']") })
	private WebElement productName;

	@FindAll({ @FindBy(id = "price:name"), @FindBy(name = "txtProductPrice"),
			@FindBy(xpath = "//input[@placeholder='Price']") })
	private WebElement productPrice;

	@FindAll({ @FindBy(xpath = "//select[@name='cmbProductUnit']"), @FindBy(id = "product:unit") })
	private WebElement unitDropDown;

	@FindAll({ @FindBy(xpath = "//select[@name='cmbProductCategory']"), @FindBy(id = "product:category") })
	private WebElement catagoryDropDown;

	@FindBy(name = "rdbStock")
	private WebElement enableCheckbox;

	@FindAll({ @FindBy(id = "product:description"), @FindBy(name = "txtProductDescription"),
			@FindBy(xpath = "//input[@placeholder='Description']") })
	private WebElement productDescription;

	@FindBy(xpath = "//input[@value='Add Product']")
	private WebElement submitAddProductBtn;

	@FindAll({ @FindBy(xpath = "//a[text()='Products']"),
			@FindBy(xpath = "//a[@href='../manufacturer/view_products.php']") })
	private WebElement productList;

	@FindBy(xpath = "//table/tbody/tr/td[3]")
	private List<WebElement> listProduct;

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;

	@FindAll({ @FindBy(xpath = "//a[text()='Manage Stock']"),
			@FindBy(xpath = "href=\"../manufacturer/manage_stock.php\"") })
	private WebElement manageStockBtn;

	@FindAll({ @FindBy(id = "btnSubmit"), @FindBy(xpath = "//input[@value='Update Stock']") })
	private WebElement manageStockSubmtBtn;
	
	@FindAll({@FindBy(xpath="//h2[text()='My Profile']")})
	private WebElement myProfileMsg;
	
	@FindBy(xpath ="//h1[text()='Add Product']")
	private WebElement addProductWelcomMsg;
	
	@FindBy(xpath ="//h1[text()='Add Product']")
	private WebElement ManufactuerWelcomMsg;
	
	@FindAll({@FindBy(xpath="//a[text()='Manage Unit']"),@FindBy(xpath="//a[@href='../manufacturer/view_unit.php']")})
	private WebElement manageUnitBtn;
	
	@FindBy(xpath="//h1[text()='View Units']")
	private WebElement manageUnitWelcomemsg;
	
	@FindAll({@FindBy(xpath="//a[text()='Manage Category']"),@FindBy(xpath="//a[@href='../manufacturer/view_category.php']")})
	private WebElement manageCatagoryBtn;
	
	@FindBy(xpath="//h1[text()='View Category']")
	private WebElement manageCatWelcomemsg;
	
	@FindAll({@FindBy(xpath="//a[text()='Edit Profile']"),@FindBy(xpath="//a[@href='../manufacturer/edit_profile.php']")})
	private WebElement editProfileBtn;
	
	@FindBy(xpath="//h1[text()='Edit Profile']")
	private WebElement editProfileWelcomemsg;
	
	@FindBy(xpath="//h1[text()='Manage Stock']")
	private WebElement manageStockWelcomemsg;
	
	@FindBy(xpath="//a[text()='Retailers']")
	private WebElement RetailerListBtn;
	
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	private List<WebElement> retailerList;

	public List<WebElement> getRetailerList() {
		return retailerList;
	}

	public WebElement getRetailerListBtn() {
		return RetailerListBtn;
	}

	public WebElement getManageStockWelcomemsg() {
		return manageStockWelcomemsg;
	}

	public WebElement getManufactuerWelcomMsg() {
		return ManufactuerWelcomMsg;
	}

	public WebElement getManageUnitBtn() {
		return manageUnitBtn;
	}

	public WebElement getManageUnitWelcomemsg() {
		return manageUnitWelcomemsg;
	}

	public WebElement getManageCatagoryBtn() {
		return manageCatagoryBtn;
	}

	public WebElement getManageCatWelcomemsg() {
		return manageCatWelcomemsg;
	}

	public WebElement getEditProfileBtn() {
		return editProfileBtn;
	}

	public WebElement getEditProfileWelcomemsg() {
		return editProfileWelcomemsg;
	}

	public WebElement getAddProductWelcomMsg() {
		return addProductWelcomMsg;
	}

	public WebElement getMyProfileMsg() {
		return myProfileMsg;
	}

	public WebElement getManageStockBtn() {
		return manageStockBtn;
	}

	public WebElement getManageStockSubmtBtn() {
		return manageStockSubmtBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getProductList() {
		return productList;
	}

	public List<WebElement> getListProduct() {
		return listProduct;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getUnitDropDown() {
		return unitDropDown;
	}

	public WebElement getCatagoryDropDown() {
		return catagoryDropDown;
	}

	public WebElement getEnableCheckbox() {
		return enableCheckbox;
	}

	public WebElement getProductDescription() {
		return productDescription;
	}

	public WebElement getSubmitAddProductBtn() {
		return submitAddProductBtn;
	}

	public ManufacturerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addProduct(String pname, String Price, String description) {
		addProductBtn.click();
		productName.sendKeys(pname);
		productPrice.sendKeys(Price);
		select(unitDropDown, " PC ");
		select(catagoryDropDown, " FASHION ");
		enableCheckbox.click();
		productDescription.sendKeys(description);
		submitAddProductBtn.click();
	}

	public void updateStock(String quantity, WebElement ele) {
		waitforElementPresent(driver, ele);
		// mouseMoveOnElement(driver, ele);
		ele.sendKeys(quantity);
	}
 }
