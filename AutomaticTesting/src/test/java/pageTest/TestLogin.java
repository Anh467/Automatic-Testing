package pageTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;
import page.Managerhomepage;

import java.time.Duration;

public class TestLogin extends TestSetUp{

    @Test
    @DisplayName("TC01-Login successfully")
    public void testLoginSuccessfully(){
        setUp("https://www.demo.guru99.com/V4/");
        loginPage.setUserName("mngr515377");
        loginPage.setPassword("umezEte");
        Managerhomepage managerhomepage = loginPage.clickLoginButton();
        String status = managerhomepage.getText();
        setWait();
        Assertions.assertTrue(status.contains("Welcome To Manager's Page of Guru99 Bank"), "Alert text is incorrect");
    }
}
