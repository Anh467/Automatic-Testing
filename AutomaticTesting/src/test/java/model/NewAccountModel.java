package model;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class NewAccountModel {

    public String CustomerId;
    public String AccountType;
    public String InitialDeposit;
    public NewAccountModel(String customerId, String accountType, String initialDeposit) {

        CustomerId = customerId;
        AccountType = accountType;
        InitialDeposit = initialDeposit;
    }
}
