package page;

import model.Authen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.Page;
public class LogoutPage extends Page{
    private Authen au;

    public LogoutPage(WebDriver driver, Authen au) {
        super(driver);
        this.au = au;
    }
    public boolean logout1(String username, String password) throws Exception {
        //get element user name
        String befor= super.getDriver().getCurrentUrl();
        WebElement ele_UserName= super.getElement(au.getEle_UserName());
        //send element user name
        super.sendKey(ele_UserName, username);
        //get element pass word
        WebElement ele_PassWord= super.getElement(au.getEle_PassWord());
        //send element pass word
        super.sendKey(ele_PassWord, password);
        super.clickEvent(au.getEle_button());
        super.clickEvent(au.getEle_herf());
        String after= super.getDriver().getCurrentUrl();
        return befor.equals(after)? false : true;
    }
}
