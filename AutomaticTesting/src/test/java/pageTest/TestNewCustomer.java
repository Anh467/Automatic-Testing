package pageTest;

import org.junit.jupiter.api.*;
import page.Addcustomerpage;
import page.CustomerRegMsg;
import page.Managerhomepage;

import java.util.Random;
import java.util.UUID;

public class TestNewCustomer extends TestSetUp{
    Managerhomepage managerhomepage;
    @BeforeEach
    public void login() {
        setUp("https://www.demo.guru99.com/V4/");
        loginPage.setUserName("mngr515377");
        loginPage.setPassword("umezEte");
        managerhomepage = loginPage.clickLoginButton();
        setWait();
    }
    @AfterEach
    public void closePage() {
        Close();
    }
    @Test
    @DisplayName("TCNC01 -Add New Customer Successfully")
    public void TCNC01(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            setWait();
            String status = customerRegMsg.getSuccessMessage();
            Assertions.assertTrue(status.contains("Customer Registered Successfully!!!"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC02 -Add New Customer Fail With Email Address Already Exist")
    public void TCNC02(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            addcustomerpage.enterEmail("a@a.aa");

            addcustomerpage.enterPassword("password123");
            CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            setWait();
            String status = customerRegMsg.getAlertText();
            customerRegMsg.ClickAccept();
            Assertions.assertTrue(status.contains("Email Address Already Exist !!"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }

    @Test
    @DisplayName("TCNC03 - Not Fill a Name field in New Customer")
    public void TCNC03(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getCustomerNameErrorMessage();
            Assertions.assertTrue(status.contains("Customer name must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC04 - Not Fill a Date field in New Customer")
    public void TCNC04(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            //addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getDateErrorMessage();
            Assertions.assertTrue(status.contains("Date Field must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC05 - Not Fill a Address field in New Customer")
    public void TCNC05(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getAddressErrorMessage();
            Assertions.assertTrue(status.contains("Address Field must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC06 - Not Fill a City field in New Customer")
    public void TCNC06(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getCityErrorMessage();
            Assertions.assertTrue(status.contains("City Field must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC07 - Not Fill a State field in New Customer")
    public void TCNC07(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getStateErrorMessage();
            Assertions.assertTrue(status.contains("State must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC08 - Not Fill a PIN field in New Customer")
    public void TCNC08(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getPinErrorMessage();
            Assertions.assertTrue(status.contains("PIN Code must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC09 - Not Fill a Telephone field in New Customer")
    public void TCNC09(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getMobileErrorMessage();
            Assertions.assertTrue(status.contains("Mobile no must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC10 - Not Fill a Email field in New Customer")
    public void TCNC10(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            addcustomerpage.enterEmail("");

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getEmailErrorMessage();
            Assertions.assertTrue(status.contains("Email-ID must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC11 - Not Fill a Password field in New Customer")
    public void TCNC11(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            addcustomerpage.enterPassword("");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getPasswordErrorMessage();
            Assertions.assertTrue(status.contains("Password must not be blank"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC12 - Fill a Pin field with character value in New Customer")
    public void TCNC12(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("abcdef");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getPinErrorMessage();
            Assertions.assertTrue(status.contains("Characters are not allowed"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC13 - Fill a Pin field with less than 6 digits value in New Customer")
    public void TCNC13(){
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")){
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("12345");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "@example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getPinErrorMessage();
            Assertions.assertTrue(status.contains("PIN Code must have 6 Digits"), "Alert text is incorrect");
        }else{
            Assertions.fail("Add New Customer page not found");
        }
    }
    @Test
    @DisplayName("TCNC14 - Fill a Email field with invalid Email in New Customer")
    public void TCNC14() {
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")) {
            addcustomerpage.enterName("John Doe");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("01/01/1990");
            addcustomerpage.enterAddress("123 Main Street");
            addcustomerpage.enterCity("New York");
            addcustomerpage.enterState("NY");
            addcustomerpage.enterPIN("123456");
            addcustomerpage.enterTelephone("1234567890");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "example.com";
            addcustomerpage.enterEmail(uuid);

            addcustomerpage.enterPassword("password123");
            //CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            //setWait();
            //String status = customerRegMsg.getAlertText();
            //customerRegMsg.ClickAccept();
            String status = addcustomerpage.getEmailErrorMessage();
            Assertions.assertTrue(status.contains("Email-ID is not valid"), "Alert text is incorrect");
        } else {
            Assertions.fail("Add New Customer page not found");
        }
    }

    @Test
    @DisplayName("TCNC15 - Add New Customer When have a field is invalid")
    public void TCNC15() {
        Addcustomerpage addcustomerpage = managerhomepage.clickAddCustomer();
        setWait();
        if (addcustomerpage.getHeadingText().contains("Add New Customer")) {
            addcustomerpage.enterName("");
            addcustomerpage.selectGender();
            addcustomerpage.enterDateOfBirth("");
            addcustomerpage.enterAddress("");
            addcustomerpage.enterCity("");
            addcustomerpage.enterState("");
            addcustomerpage.enterPIN("");
            addcustomerpage.enterTelephone("");

            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0, 10) + "example.com";
            addcustomerpage.enterEmail("");

            addcustomerpage.enterPassword("");
            CustomerRegMsg customerRegMsg = addcustomerpage.clickSubmitButton();
            setWait();
            String status = customerRegMsg.getAlertText();
            customerRegMsg.ClickAccept();
            Assertions.assertTrue(status.contains("please fill all fields"), "Alert text is incorrect");
        } else {
            Assertions.fail("Add New Customer page not found");
        }
    }
}


