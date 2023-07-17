package pageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestSetUp {
    private WebDriver driver;
    protected LoginPage loginPage;
    public void setUp(String link){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(link);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        loginPage = new LoginPage(driver);
    }
    public void setWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public  void Close(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }
}
