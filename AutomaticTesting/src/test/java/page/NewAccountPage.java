package page;

import model.Authen;
import model.NewAccountModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAccountPage extends Page{
    String WebHref= "https://www.demo.guru99.com/V4/";
    final private By ele_CustomerId= By.name("cusid");
    final private By ele_AccountType= By.name("selaccount");
    final private By ele_InitialDeposit=  By.name("inideposit");
    final private By btn_Submit=  By.name("button2");
    final private By btn_Reset= By.name("reset");
    private  NewAccountModel newAccountModel;
    public NewAccountPage(WebDriver driver, NewAccountModel newAccountModel) {
        super(driver);
        this.newAccountModel= newAccountModel;
    }
    public boolean checkBlank(){
        WebElement CustomerId= super.getElement(this.ele_CustomerId);
        WebElement InitialDeposit= super.getElement(this.ele_InitialDeposit);
        if(CustomerId.getText().trim().equals("")||InitialDeposit.getText().trim().equals(""))
            return true;
        return false;
    }
    public String getAlert(){
        Alert alert = super.getDriver().switchTo().alert();
        String alertText = alert.getText();
        return alertText;
    }
    public void send(){
        // send key
        WebElement ele_CustomerId= super.getElement(this.ele_CustomerId);
        WebElement ele_AccountType= super.getElement(this.ele_AccountType);
        WebElement ele_InitialDeposit= super.getElement(this.ele_InitialDeposit);
        super.sendKey(ele_CustomerId, newAccountModel.CustomerId);
        // chuwa duuoc
        super.selectioṇ̣(ele_AccountType, newAccountModel.AccountType);
        super.sendKey(ele_InitialDeposit, newAccountModel.InitialDeposit);
    }
    public void Submit(){
        send();
        // nhan submit
        super.clickEvent(this.btn_Submit);
    }
    public void Reset(){
        send();
        super.clickEvent(this.btn_Reset);
    }

    public String getWebHref() {
        return WebHref;
    }

    public void setWebHref(String webHref) {
        WebHref = webHref;
    }
}
