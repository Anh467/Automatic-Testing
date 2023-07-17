package page;

import model.Authen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends Page {
    private Authen authen;

    public SignInPage(WebDriver driver, Authen authen) {
        super(driver);
        this.authen = authen;
    }

    public boolean signin(String userid, String password) throws Exception {
        WebElement ele_UserID = super.getElement(authen.getEle_UserID());
        super.sendKey(ele_UserID, userid);

        WebElement ele_PassWord = super.getElement(authen.getEle_PassWord());
        super.sendKey(ele_PassWord, password);

        WebElement ele_button = super.getElement(authen.getEle_button());
        super.clickEvent(ele_button);

        // Kiểm tra logic xử lý đăng nhập và trả về kết quả tương ứng
        // ...

        return true; // Hoặc false tùy theo kết quả kiểm tra
    }
}
