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
import page.LogoutPage;
import page.SignInPage;

public class LogoutPageTest extends BaseSetUp {
    String website = "http://www.demo.guru99.com/V4/";
    private WebDriver driver;
    public LogoutPage logoutPage;
    private Authen au;

    public LogoutPageTest(String webHref) {
        super(webHref);
        this.au = getAuthen();
    }

    public Authen getAuthen() {
        By ele_button = By.name("btnLogin");
        By ele_userName = By.name("uid");
        By ele_passWord = By.name("password");
        By ele_herf = By.xpath("//a[contains(@href, 'Logout.php')]");
        String UserName = "Admin";
        String PassWord = "admin123";
        //Create credential element
        //String WebsiteHref, String UserName, String PassWord, By ele_UserName, By ele_PassWord, By ele_button
        return new Authen(ele_userName, ele_passWord, ele_button,ele_herf);
    }

    @BeforeClass
    public void setUp() {
        this.driver = super.getDriver();
        this.au = getAuthen();

    }

    @Test()
    @DisplayName("TC-01 Logout successfully")
    public void logout() throws Exception {
        String username = "mngr515377";
        String password = "umezEte";
        LogoutPage LogoutPage = new LogoutPage(super.getDriver(), au);
        boolean check = LogoutPage.logout1(username, password);
        Assert.assertTrue(check);
    }
}
