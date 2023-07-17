package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By userNameTxt = By.name("uid");
    private By passwordTxt = By.name("password");
    private By loginbutton = By.cssSelector("input[name='btnLogin'][value='LOGIN']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void setUserName(String userName){
        driver.findElement(userNameTxt).sendKeys(userName);
    }
    public void setPassword(String password){
        driver.findElement(passwordTxt).sendKeys(password);
    }
    public Managerhomepage clickLoginButton(){
        driver.findElement(loginbutton).click();
        return new page.Managerhomepage(driver);
    }
}
