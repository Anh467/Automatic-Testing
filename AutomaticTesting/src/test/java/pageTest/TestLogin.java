package pageTest;

import base.TestSetUp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.Managerhomepage;

public class TestLogin extends TestSetUp {
    @AfterEach
    void ClosePage(){
        this.Close();
    }
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
