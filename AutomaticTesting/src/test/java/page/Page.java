package page;
import model.Authen;
import model.Credential;
import model.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Page {
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By by){
        System.out.println("done get element:");
        return this.driver.findElement(by);
    }
    public void sendKey(WebElement webElement, String key){
        webElement.sendKeys(key);
        System.out.println("done send keys:");
    }
    public void clickEvent(By ele_button){
        this.driver.findElement(ele_button).click();
        System.out.println("done click:");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
