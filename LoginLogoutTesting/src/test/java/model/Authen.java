package model;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class Authen{
    private By ele_UserName;
    private By ele_PassWord;
    private By ele_button;
    private By ele_herf;

    public By getEle_herf() {
        return ele_herf;
    }

    public void setEle_herf(By ele_herf) {
        this.ele_herf = ele_herf;
    }

    public Authen(By ele_UserName, By ele_PassWord, By ele_button, By ele_herf) {
        this.ele_UserName = ele_UserName;
        this.ele_PassWord = ele_PassWord;
        this.ele_button = ele_button;
        this.ele_herf = ele_herf;
    }

    public Authen(By ele_UserName, By ele_PassWord, By ele_button) {
        this.ele_UserName = ele_UserName;
        this.ele_PassWord = ele_PassWord;
        this.ele_button = ele_button;
    }
    public void setCredential(String userName, String passWord){
        this.ele_UserName = ele_UserName;
        this.ele_PassWord = ele_PassWord;
    }



    public By getEle_UserName() {
        return ele_UserName;
    }

    public void setEle_UserName(By ele_UserName) {
        this.ele_UserName = ele_UserName;
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
