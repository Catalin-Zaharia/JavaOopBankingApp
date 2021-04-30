package service;

import model.Account;
import model.Currency;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadService {

    Scanner currencyScanner, userScanner, accountScanner;

    {
        try {
            currencyScanner = new Scanner(new File(DIRECTORY_PATH+"Currencies.csv"));
            userScanner = new Scanner(new File(DIRECTORY_PATH+"Users.csv"));
            accountScanner = new Scanner(new File(DIRECTORY_PATH+"AccountValues.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String DIRECTORY_PATH = "resources/inputs/";

    private static ReadService single_instance =null;

    private ReadService(){}

    public static ReadService getInstance()
    {
        if (single_instance == null)
            single_instance = new ReadService();

        return single_instance;
    }

    public Currency readNextCurrency(){
        String[] words = currencyScanner.nextLine().split(",");
        return new Currency(words[0], words[1], Double.parseDouble(words[2]));
    }

    public User readNextUser(){
        String[] words = userScanner.nextLine().split(",");
        return new User(words[0], words[1]);
    }

    public Account readNextAccount(User user, Currency currency){
        double value = Double.parseDouble(accountScanner.nextLine());
        return AccountService.getInstance().createAccount(user, currency, value);
    }
}
