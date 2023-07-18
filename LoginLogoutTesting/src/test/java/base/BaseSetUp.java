package base;
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

import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class BaseSetUp {
    private WebDriver driver;
    private String webHref;
    String driverPath;
    //final String  userNameID= "user";
    //final String  passWordID= "pass";
    public BaseSetUp(String webHref){
        //setup for web
        this.driverPath= "src/main/resources/chromedriver.exe";
        this.webHref= "http://www.demo.guru99.com/V4/";;
        initBrowserDriver();
       /* WebDriverWait wait = new WebDriverWait(driver,20); //20 seconds
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();*/
    }

    public void initBrowserDriver(){
        //this.step= new Step();
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
        this.driver.get(webHref);
        this.driver.manage().window().fullscreen();
        //this.step.setStep("Access to system");
        this.driver.navigate().to(webHref);
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void driverQuit(){
        this.driver.quit();
    }

    public static void main(String[] args){
        //E4();
        //E5();
    }
}
