package page;

import model.FundTranfer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.Page;

public class FundTranferPage extends Page {
    private FundTranfer tranfer;
    public FundTranferPage(WebDriver driver, FundTranfer tranfer) {
        super(driver);
        this.tranfer = tranfer;
    }

    public void Tranfer(String payerAccount, String payeeAccount, String Amount, String descript){
        //
        String befor= super.getDriver().getCurrentUrl();
        WebElement ele_payerAccount= super.getElement(tranfer.getEle_payers_account());

        super.sendKey(ele_payerAccount, payerAccount);

        WebElement ele_PayeeAccount = super.getElement(tranfer.getEle_payees_account());
        super.sendKey(ele_PayeeAccount, payeeAccount);

        WebElement ele_amount = super.getElement(tranfer.getAmount());
        super.sendKey(ele_amount, Amount);

        WebElement ele_descript = super.getElement(tranfer.getDescription());
        super.sendKey(ele_descript, descript);

        super.clickEvent(tranfer.getEle_button());
    }
}
