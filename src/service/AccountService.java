package service;

import model.*;

import java.util.Random;
import java.util.Scanner;

public class AccountService {

    private static AccountService single_instance =null;

    private  Scanner scanner;

    private AccountService(){}

    public static AccountService getInstance()
    {
        if (single_instance == null)
            single_instance = new AccountService();

        return single_instance;
    }

    public Account createAccount(User user, Currency currency, double startingAmount){
        LogService.getInstance().logThis("createAccount");
        Random rand = new Random();
        String iban = String.format("RO00BANK292fa1904h9x%d", rand.nextInt(1000));
        return new Account(user, currency, startingAmount, iban);
    }

    public Account voidAccount(){
        LogService.getInstance().logThis("voidAccount");
        return null;
    }


}
