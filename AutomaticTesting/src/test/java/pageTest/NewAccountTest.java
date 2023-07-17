package pageTest;

import base.BaseSetUp;
import model.Authen;
import model.NewAccountModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.NewAccountPage;
import page.SignInPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NewAccountTest extends BaseSetUp {
    final String USERID= "mngr515377";
    final String PASSWORD= "umezEte";
    final String CUSTOMERID = "83044";
    final String SAVE= "Savings";
    final String CUR= "Current";
    List<String> AccountID= new ArrayList<>();
    String website= "https://www.demo.guru99.com/V4/index.php";
    private WebDriver driver;
    public SignInPage signInPage;
    private NewAccountModel accountModel;
    public NewAccountTest(String website) {
        super(website);
        AccountID.add("124344");
        AccountID.add("124347");
    }

    public void signin(){
        By uid= By.name("uid");
        By password= By.name("password");
        By btn_login= By.name("btnLogin");
        driver.findElement(uid).sendKeys(this.USERID);
        driver.findElement(password).sendKeys(this.PASSWORD);
        driver.findElement(btn_login).click();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    public void switchPage(){
        By href= By.xpath("//a[@href='addAccount.php']");
        driver.findElement(href).click();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    public void adsvertisment(){

    }
    @BeforeClass
    public void setUp(){
        this.driver= super.getDriver();
        signin();
        switchPage();
    }
    @Test()
    @DisplayName("TC-01 Account Generated Successfully With Saving!!")
    public void AccountGeneratedSuccessfullyWithSaving() throws Exception {
        NewAccountModel newAccountModel= new NewAccountModel(CUSTOMERID, SAVE, "500");
        NewAccountPage newAccountPage= new NewAccountPage(this.driver, newAccountModel);
        newAccountPage.Submit();
        WebElement element = this.driver.findElement(By.xpath("//p[@class='heading3' and @align='center']"));
        boolean check=element.getText().trim().equalsIgnoreCase("Account Generated Successfully!!!");
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-02 Account Generated Successfully With Current!!!")
    public void AccountGeneratedSuccessfullyWithCurrent() throws Exception {
        NewAccountModel newAccountModel= new NewAccountModel(CUSTOMERID, CUR, "500");
        NewAccountPage newAccountPage= new NewAccountPage(this.driver, newAccountModel);
        newAccountPage.Submit();
        WebElement element = this.driver.findElement(By.xpath("//p[@class='heading3' and @align='center']"));
        boolean check=element.getText().trim().equalsIgnoreCase("Account Generated Successfully!!!");
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-03 Intial deposite must be Rs. 500 or more!!!")
    public void InitialDepositUnder500() throws Exception {
        NewAccountModel newAccountModel= new NewAccountModel(CUSTOMERID, SAVE, "400");
        NewAccountPage newAccountPage= new NewAccountPage(driver, newAccountModel);
        newAccountPage.Submit();
        String alertText= super.getAlert();
        boolean check=alertText.trim().equalsIgnoreCase("Intial deposite must be Rs. 500 or more");
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-04 Customer Is Blank!!!")
    public void CustomerIdBlank() throws Exception {
        NewAccountModel newAccountModel= new NewAccountModel("", SAVE, "400");
        NewAccountPage newAccountPage= new NewAccountPage(driver, newAccountModel);
        newAccountPage.Submit();
        String alertText= super.getAlert();
        boolean check=alertText.trim().equalsIgnoreCase("Please fill all fields");
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-05 Initial Deposit Is Blank!!!")
    public void InitialDepositIdBlank() throws Exception {
        NewAccountModel newAccountModel= new NewAccountModel(CUSTOMERID, SAVE, "");
        NewAccountPage newAccountPage= new NewAccountPage(driver, newAccountModel);
        newAccountPage.Submit();
        String alertText= super.getAlert();
        boolean check=alertText.trim().equalsIgnoreCase("Please fill all fields");
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-06 Check Reset!!!")
    public void Rest() throws Exception {
        NewAccountPage newAccountPage= new NewAccountPage(driver, null);
        newAccountPage.Reset();
        boolean check= newAccountPage.checkBlank();
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-07 Invalid CUSTOMER ID character!!")
    public void InvalidCUSTOMERIDcharacter() throws Exception {
        NewAccountModel newAccountModel= new NewAccountModel("dasfa", SAVE, "500");
        NewAccountPage newAccountPage= new NewAccountPage(this.driver, newAccountModel);
        newAccountPage.Submit();
        WebElement element = this.driver.findElement(By.xpath("//p[@class='heading3' and @align='center']"));
        boolean check=element.getText().trim().equalsIgnoreCase("Please fill all fields");
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-08 Invalid Initial deposit with charactor ID!!")
    public void  InvalidInitialdeposit() throws Exception {
        NewAccountModel newAccountModel= new NewAccountModel(CUSTOMERID, SAVE, "500,qweru");
        NewAccountPage newAccountPage= new NewAccountPage(this.driver, newAccountModel);
        newAccountPage.send();
        WebElement element = this.driver.findElement(By.id("message19"));
        boolean check=element.getText().trim().equalsIgnoreCase("Characters are not allowed");
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-09 Invalid Customer ID !!")
    public void  IInvalidCustomerID() throws Exception {
        NewAccountModel newAccountModel= new NewAccountModel("123", SAVE, "500");
        NewAccountPage newAccountPage= new NewAccountPage(this.driver, newAccountModel);
        newAccountPage.Submit();
        String alertText= super.getAlert();
        boolean check=alertText.trim().equalsIgnoreCase("Customer does not exist!!");
        Assert.assertTrue(check);
    }
    @AfterEach
    public void end(){
        //super.driverQuit();
    }
}
