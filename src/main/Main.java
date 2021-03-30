package main;

import model.*;
import service.*;


public class Main {
    public static void main(String[] args) {
        
        Currency dollar = new Currency("Dollar", "USD", 1);
        Currency leu = new Currency("Romanian Leu", "RON", 0.2);

        User user1 = new User("fn1", "ln1");
        User user2 = new User("fn2", "ln2");
        Account cont1 = AccountService.createAccount(user1, leu, 1000);
        Account cont2 = AccountService.createAccount(user2, dollar, 200);

        AccountService.activateCard(cont1, "debit");
        System.out.println(cont1.getLastCard().getPin());
        AccountService.changePin(cont1, cont1.getLastCard());
        System.out.println(cont1.getLastCard().getPin());

        AccountService.transferFunds(100, cont1, cont2);
        System.out.println(cont2.getAmount());

        AccountService.getAllTransfers(cont1);
    }
}
