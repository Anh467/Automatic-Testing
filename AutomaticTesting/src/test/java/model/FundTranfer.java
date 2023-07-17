package model;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class FundTranfer {
    private By ele_payers_account;
    private By ele_payees_account;
    private By amount;
    private By description;
    private By ele_button;


    public FundTranfer(By ele_payers_account, By ele_payees_account, By amount, By description, By ele_button) {
        this.ele_payers_account = ele_payers_account;
        this.ele_payees_account = ele_payees_account;
        this.amount = amount;
        this.description = description;
        this.ele_button = ele_button;
    }

    public By getEle_payers_account() {
        return ele_payers_account;
    }

    public void setEle_payers_account(By ele_payers_account) {
        this.ele_payers_account = ele_payers_account;
    }

    public By getEle_payees_account() {
        return ele_payees_account;
    }

    public void setEle_payees_account(By ele_payees_account) {
        this.ele_payees_account = ele_payees_account;
    }

    public By getAmount() {
        return amount;
    }

    public void setAmount(By amount) {
        this.amount = amount;
    }

    public By getDescription() {
        return description;
    }

    public void setDescription(By description) {
        this.description = description;
    }
    public By getEle_button() {
        return ele_button;
    }

    public void setEle_button(By ele_button) {
        this.ele_button = ele_button;
    }

}
