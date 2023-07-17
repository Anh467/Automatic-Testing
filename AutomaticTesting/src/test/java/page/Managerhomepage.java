package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Managerhomepage {
    private WebDriver driver;
    private By statusAlert = By.cssSelector("marquee.heading3");
    private By newCustomer = By.linkText("New Customer");
    public Managerhomepage(WebDriver driver) {
        this.driver = driver;
    }
    public String getText(){
        return driver.findElement(statusAlert).getText();
    }
    public Addcustomerpage clickAddCustomer(){
        driver.findElement(newCustomer).click();
        return  new Addcustomerpage(driver);
    }
}
