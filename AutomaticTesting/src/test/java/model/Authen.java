package model;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class Authen{
    private By ele_UserID;
    private By ele_PassWord;
    private By ele_button;

    public Authen(By ele_UserID, By ele_PassWord, By ele_button) {
        this.ele_UserID = ele_UserID;
        this.ele_PassWord = ele_PassWord;
        this.ele_button = ele_button;
    }
    public void setCredential(String UserID, String passWord){
        this.ele_UserID = ele_UserID;
        this.ele_PassWord = ele_PassWord;
    }



    public By getEle_UserID() {
        return ele_UserID;
    }


    public void setEle_UserID(By ele_UserID) {
        this.ele_UserID = ele_UserID;
    }

    public By getEle_PassWord() {
        return ele_PassWord;
    }

    public void setEle_PassWord(By ele_PassWord) {
        this.ele_PassWord = ele_PassWord;
    }

    public By getEle_button() {
        return ele_button;
    }

    public void setEle_button(By ele_button) {
        this.ele_button = ele_button;
    }


}
