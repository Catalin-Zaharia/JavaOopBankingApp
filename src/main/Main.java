package main;

import model.*;
import service.*;


public class Main {
    public static void main(String[] args) {

        AccountService accountService = AccountService.getInstance();
        CardService cardService = CardService.getInstance();
        TransferService transferService = TransferService.getInstance();
        ReadService readService = ReadService.getInstance();

        Currency dollar = readService.readNextCurrency();
        //Currency leu = readService.readNextCurrency();

        User user1 = readService.readNextUser();
        //User user2 = readService.readNextUser();

        Account cont1 = readService.readNextAccount(user1, readService.readNextCurrency());
        Account cont2 = readService.readNextAccount(readService.readNextUser(), dollar);
        //cont2 = accountService.voidAccount();
        /*
        Currency dollar = new Currency("Dollar", "USD", 1);
        Currency leu = new Currency("Romanian Leu", "RON", 0.2);

        User user1 = new User("fn1", "ln1");
        User user2 = new User("fn2", "ln2");

        Account cont1 = accountService.createAccount(user1, leu, 1000);
        Account cont2 = accountService.createAccount(user2, dollar, 200);
        */
        cardService.activateCard(cont1, "debit");
        System.out.println(cont1.getLastCard().getPin());
        cardService.changePin(cont1, cont1.getLastCard());
        System.out.println(cont1.getLastCard().getPin());

        transferService.transferFunds(100, cont1, cont2);
        System.out.println(cont2.getAmount());

        transferService.getAllTransfers(cont2);

    }
}
