package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addcustomerpage {
    WebDriver driver;
    By headingElement = By.className("heading3");

    By nameInput = By.name("name");
    By genderInput = By.cssSelector("input[type='radio'][value='f']");
    By dobInput = By.id("dob");
    By addressTextarea = By.tagName("textarea");
    By cityInput = By.name("city");
    By stateInput = By.name("state");
    By pinInput = By.name("pinno");
    By telephoneInput = By.name("telephoneno");
    By emailInput = By.name("emailid");
    By passwordInput = By.name("password");

    By customerNameErrorMessage = By.id("message");
    By dateErrorMessage = By.id("message24");
    By addressErrorMessage = By.id("message3");
    By cityErrorMessage = By.id("message4");
    By stateErrorMessage = By.id("message5");
    By pinErrorMessage = By.id("message6");
    By mobileErrorMessage = By.id("message7");
    By emailErrorMessage = By.id("message9");
    By passwordErrorMessage = By.id("message18");

    By submitButton = By.cssSelector("input[type='submit'][name='sub']");

    public Addcustomerpage(WebDriver driver) {
        this.driver = driver;
    }
    public String getHeadingText(){
        return driver.findElement(headingElement).getText();
    }

    public void enterName(String name) {
        WebElement nameElement = driver.findElement(nameInput);
        nameElement.sendKeys(name);
    }
    public void selectGender() {
        WebElement genderElement = driver.findElement(genderInput);
        genderElement.click();
    }

    public void enterDateOfBirth(String dob) {
        WebElement dobElement = driver.findElement(dobInput);
        dobElement.sendKeys(dob);
    }

    public void enterAddress(String address) {
        WebElement addressElement = driver.findElement(addressTextarea);
        addressElement.sendKeys(address);
    }

    public void enterCity(String city) {
        WebElement cityElement = driver.findElement(cityInput);
        cityElement.sendKeys(city);
    }

    public void enterState(String state) {
        WebElement stateElement = driver.findElement(stateInput);
        stateElement.sendKeys(state);
    }

    public void enterPIN(String pin) {
        WebElement pinElement = driver.findElement(pinInput);
        pinElement.sendKeys(pin);
    }

    public void enterTelephone(String telephone) {
        WebElement telephoneElement = driver.findElement(telephoneInput);
        telephoneElement.sendKeys(telephone);
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailInput);
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.sendKeys(password);
    }

    public String getCustomerNameErrorMessage() {
        WebElement errorMessage = driver.findElement(customerNameErrorMessage);
        return errorMessage.getText();
    }

    public String getDateErrorMessage() {
        WebElement errorMessage = driver.findElement(dateErrorMessage);
        return errorMessage.getText();
    }

    public String getAddressErrorMessage() {
        WebElement errorMessage = driver.findElement(addressErrorMessage);
        return errorMessage.getText();
    }

    public String getCityErrorMessage() {
        WebElement errorMessage = driver.findElement(cityErrorMessage);
        return errorMessage.getText();
    }

    public String getStateErrorMessage() {
        WebElement errorMessage = driver.findElement(stateErrorMessage);
        return errorMessage.getText();
    }

    public String getPinErrorMessage() {
        WebElement errorMessage = driver.findElement(pinErrorMessage);
        return errorMessage.getText();
    }

    public String getMobileErrorMessage() {
        WebElement errorMessage = driver.findElement(mobileErrorMessage);
        return errorMessage.getText();
    }

    public String getEmailErrorMessage() {
        WebElement errorMessage = driver.findElement(emailErrorMessage);
        return errorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        WebElement errorMessage = driver.findElement(passwordErrorMessage);
        return errorMessage.getText();
    }

    public CustomerRegMsg clickSubmitButton() {
        driver.findElement(submitButton).click();
        return new CustomerRegMsg(driver);
    }

}
