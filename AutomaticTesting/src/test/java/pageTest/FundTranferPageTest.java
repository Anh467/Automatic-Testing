package pageTest;

import base.BaseSetUp;
import model.FundTranfer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.FundTranferPage;
import page.Page;

import java.time.Duration;

public class FundTranferPageTest extends BaseSetUp{
    String website= "https://www.demo.guru99.com/V4/manager/FundTransInput.php";
    private WebDriver driver;
    public FundTranferPage tranferPage;
    private FundTranfer fundTranfer;

    public FundTranferPageTest(String webHref)
    {
        super(webHref);
        this.fundTranfer = getTranfer();

    }
    public FundTranfer getTranfer(){
        By ele_button= By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input[1]");
        By ele_payer= By.name("payersaccount");
        By ele_payee= By.name("payeeaccount");
        By ele_amount = By.name("ammount");
        By ele_descript = By.name("desc");

        //Create credential element
        //String WebsiteHref, String UserName, String PassWord, By ele_UserName, By ele_PassWord, By ele_button
        return new FundTranfer(ele_payer, ele_payee, ele_amount, ele_descript, ele_button);
    }

    final String USERID= "mngr515377";
    final String PASSWORD= "umezEte";
    final String CUSTOMERID = "83044";

    public void signin(){
        By uid= By.name("uid");
        By password= By.name("password");
        By btn_login= By.name("btnLogin");
        By a_FundTranfer = By.xpath("/html/body/div[3]/div/ul/li[10]/a");
        driver.findElement(uid).sendKeys(this.USERID);
        driver.findElement(password).sendKeys(this.PASSWORD);
        driver.findElement(btn_login).click();
        driver.findElement(a_FundTranfer).click();

    }

    public String getAlert(){
        Alert alert = super.getDriver().switchTo().alert();
        String alertText = alert.getText();
        return alertText;
    }

//    public String Notification() {
//        WebElement errorMessageElement = super.getDriver().findElement(By.id("message10"));
//        String errorMessage = errorMessageElement.getText();
//        return errorMessage;
//    }

    @BeforeClass
    public void setUp(){
        this.driver= super.getDriver();
        this.fundTranfer= getTranfer();

    }
    @Test()
    @DisplayName("TC-01 Tranfer account does not exist!!!")
    public void tranfer() throws Exception {
        String payers= "012344";
        String payees = "012345";
        String Amount ="100";
        String Decript ="good";
        signin();
        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranfer(payers, payees, Amount, Decript);

        System.out.println(getAlert());
        Assertions.assertTrue(getAlert().contains("does not exist!!!"), "Alert text is incorrect");
    }

    @Test()
    @DisplayName("TC-02 Tranfer false Payers Account")
    public void tranfer2() throws Exception {
        String payers= "012344aaa";
        String payees = "012345";
        String Amount ="100";
        String Decript ="good";
        signin();

        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranferwithoutclick(payers, payees, Amount, Decript);

//        System.out.println(getAlert());
//        Assertions.assertTrue(getAlert().contains("Please fill all fields"), "Alert text is incorrect");

        WebElement errorMessageElement = super.getDriver().findElement(By.id("message10"));
        String errorMessage = errorMessageElement.getText();
        System.out.println(errorMessage);
        Assertions.assertTrue(errorMessage.contains("Characters are not allowed"), "false");
    }

    @Test()
    @DisplayName("TC-03 Tranfer false Payees Account")
    public void tranfer3() throws Exception {
        String payers= "012344";
        String payees = "012345aaaaa";
        String Amount ="100";
        String Decript ="good";
        signin();

        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranferwithoutclick(payers, payees, Amount, Decript);

        WebElement errorMessageElement = super.getDriver().findElement(By.id("message11"));
        String errorMessage = errorMessageElement.getText();
        System.out.println(errorMessage);
        Assertions.assertTrue(errorMessage.contains("Characters are not allowed"), "false");
    }

    @Test()
    @DisplayName("TC-04 Tranfer false Amount")
    public void tranfer4() throws Exception {
        String payers= "012344";
        String payees = "012345";
        String Amount ="100aa";
        String Decript ="good";
        signin();

        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranferwithoutclick(payers, payees, Amount, Decript);

        WebElement errorMessageElement = super.getDriver().findElement(By.id("message1"));
        String errorMessage = errorMessageElement.getText();
        System.out.println(errorMessage);
        Assertions.assertTrue(errorMessage.contains("Characters are not allowed"), "false");

    }

    @Test()
    @DisplayName("TC-05 Tranfer description blank")
    public void tranfer5() throws Exception {
        String payers= "012344334";
        String payees = "012345345";
        String Amount ="100";
        String Decript ="";
        signin();

        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranfer(payers, payees, Amount, Decript);

//        System.out.println(getAlert());
//        Assertions.assertTrue(getAlert().contains("Please fill all fields"), "Alert text is incorrect");
        WebElement errorMessageElement = super.getDriver().findElement(By.id("message17"));
        String errorMessage = errorMessageElement.getText();
        System.out.println(errorMessage);
        Assertions.assertTrue(errorMessage.contains("Description can not be blank"), "false");
    }

    @Test()
    @DisplayName("TC-06 Tranfer Payers blank ")
    public void tranfer6() throws Exception {
        String payers= "";
        String payees = "0123454435";
        String Amount ="100";
        String Decript ="good";
        signin();

        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranferwithoutclick(payers, payees, Amount, Decript);

        WebElement errorMessageElement = super.getDriver().findElement(By.id("message10"));
        String errorMessage = errorMessageElement.getText();
        System.out.println(errorMessage);
        Assertions.assertTrue(errorMessage.contains("Payers Account Number must not be blank"), "false");
    }

    @Test()
    @DisplayName("TC-07 Payees blank")
    public void tranfer7() throws Exception {
        String payers= "012344345";
        String payees = "";
        String Amount ="100";
        String Decript ="good";
        signin();
        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranferwithoutclick(payers, payees, Amount, Decript);

        WebElement errorMessageElement = super.getDriver().findElement(By.id("message11"));
        String errorMessage = errorMessageElement.getText();
        System.out.println(errorMessage);
        Assertions.assertTrue(errorMessage.contains("Payees Account Number must not be blank"), "false");
    }

    @Test()
    @DisplayName("TC-08 Amount blank")
    public void tranfer8() throws Exception {
        String payers= "12344565";
        String payees = "12355345";
        String Amount ="";
        String Decript ="good";
        signin();
        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranferwithoutclick(payers, payees, Amount, Decript);

        WebElement errorMessageElement = super.getDriver().findElement(By.id("message1"));
        String errorMessage = errorMessageElement.getText();
        System.out.println(errorMessage);
        Assertions.assertTrue(errorMessage.contains("Amount field must not be blank"), "false");
    }

    @Test()
    @DisplayName("TC-09 Tranfer successfully")
    public void tranfer9() throws Exception {
        String payers= "";
        String payees = "";
        String Amount ="";
        String Decript ="";
        signin();
        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranfer(payers, payees, Amount, Decript);

        WebElement errorMessageElement1 = super.getDriver().findElement(By.id("message10"));
        String errorMessage1 = errorMessageElement1.getText();
        WebElement errorMessageElement2 = super.getDriver().findElement(By.id("message11"));
        String errorMessage2 = errorMessageElement2.getText();
        WebElement errorMessageElement3 = super.getDriver().findElement(By.id("message1"));
        String errorMessage3 = errorMessageElement3.getText();
        WebElement errorMessageElement4 = super.getDriver().findElement(By.id("message17"));
        String errorMessage4 = errorMessageElement4.getText();
        Assertions.assertTrue(errorMessage1.contains("Payers Account Number must not be blank")
                && errorMessage2.contains("Payees Account Number must not be blank")
                && errorMessage3.contains("Amount field must not be blank")
                && errorMessage4.contains("Description can not be blank"), "false");
    }

    @Test()
    @DisplayName("TC-10 Tranfer successfully")
    public void tranfer10() throws Exception {
        String payers= "20339183224";
        String payees = "5007205126890";
        String Amount ="100000";
        String Decript ="good";
        signin();
        tranferPage = new FundTranferPage(super.getDriver(), fundTranfer);
        tranferPage.Tranfer(payers, payees, Amount, Decript);

        System.out.println(getAlert());
        Assertions.assertTrue(getAlert().contains("Successfully"), "Alert text is incorrect");
    }

    @AfterClass
    public void quitBrowser(){

        //super.driverQuit();
    }
}
