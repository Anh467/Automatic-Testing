package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerRegMsg {
    WebDriver driver;
    By successMessage = By.cssSelector("p.heading3[align='center']");

    public CustomerRegMsg(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        WebElement element = driver.findElement(successMessage);
        return element.getText();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public void ClickAccept(){
        driver.switchTo().alert().accept();
    }
}
