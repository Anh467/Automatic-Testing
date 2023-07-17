package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public void sendKey(WebElement webElement, String key) {
        webElement.sendKeys(key);
        System.out.println("done send keys:");
    }

    public void clickEvent(WebElement element) {
        element.click();
        System.out.println("done click:");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
