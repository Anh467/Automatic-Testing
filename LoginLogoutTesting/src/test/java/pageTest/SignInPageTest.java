package pageTest;

import base.BaseSetUp;
import model.Authen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.SignInPage;

public class SignInPageTest extends BaseSetUp {
    String website= "http://www.demo.guru99.com/V4/";
    private WebDriver driver;
    public SignInPage signInPage;
    private Authen au;
    public SignInPageTest(String webHref) {
        super(webHref);
        this.au= getAuthen();
    }
    public Authen getAuthen(){
        By ele_button= By.name("btnLogin");
        By ele_userName= By.name("uid");
        By ele_passWord= By.name("password");
        String UserName= "Admin";
        String PassWord= "admin123";
        //Create credential element
        //String WebsiteHref, String UserName, String PassWord, By ele_UserName, By ele_PassWord, By ele_button
       return new Authen(ele_userName, ele_passWord, ele_button);
    }
    @BeforeClass
    public void setUp(){
        this.driver= super.getDriver();
        this.au= getAuthen();

    }
    @Test()
    @DisplayName("TC-01 Login successfully")
    public void signin() throws Exception {
        String username= "mngr515377";
        String password = "umezEte";
        signInPage= new SignInPage(super.getDriver(), au);
        boolean check= signInPage.signin(username,password);
        Assert.assertTrue(check);
    }
    @Test()
    @DisplayName("TC-02 Login with invalid credentials")
    public void signinInvalidCredentials() throws Exception {
        String username = "InvalidUser";
        String password = "invalidpassword";
        signInPage = new SignInPage(super.getDriver(), au);
        boolean check= signInPage.signin(username,password);
        Assert.assertFalse(check);
    }
    @Test()
    @DisplayName("TC-03 Login with invalid user name and validpass")
    public void signinInvalidUserNameAndvalidpass() throws Exception {
        String username = "InvalidUser";
        String password = "invalidpassword";
        signInPage = new SignInPage(super.getDriver(), au);
        boolean check= signInPage.signin(username,password);
        Assert.assertFalse(check);
    }
    @Test()
    @DisplayName("TC-04 Login with invalid user name and validpass")
    public void signinInvalidUserName() throws Exception {
        String username = "mngr515377";
            String password = "admin  123";
        signInPage = new SignInPage(super.getDriver(), au);
        boolean check= signInPage.signin(username,password);
        Assert.assertFalse(check);
    }
    @Test()
    @DisplayName("TC-05 Login with valid user name and invalid pass")
    public void signinInvaluePass() throws Exception {
        String username = "umezEte";
        String password = "umezEte";
        signInPage = new SignInPage(super.getDriver(), au);
        boolean check= signInPage.signin(username,password);
        Assert.assertFalse(check);
    }
    @Test()
    @DisplayName("TC-06 Login with none name and invalid pass")
    public void signinNonedUserName() throws Exception {
        String username = " ";
        String password = "umezEte";
        signInPage = new SignInPage(super.getDriver(), au);
        boolean check= signInPage.signin(username,password);
        Assert.assertFalse(check);
    }
    @Test()
    @DisplayName("TC-07 Login with invalid user name and none pass")
    public void signinNonePass() throws Exception {
        String username = "mngr515377";
        String password = " ";
        signInPage = new SignInPage(super.getDriver(), au);
        boolean check= signInPage.signin(username,password);
        Assert.assertFalse(check);
    }
    @AfterClass
    public void quitBrowser(){
        super.driverQuit();
    }
}
