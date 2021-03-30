package service;

import model.Account;
import model.Currency;
import model.Transfer;

public class CurrencyService {
    
    public static double convertCurrency(double ammount, Currency fromCurrency, Currency toCurrency){
        return ammount*fromCurrency.getExchangeRate()/toCurrency.getExchangeRate();
    }

    public static void makeTransfer(double amountSent, Account fromAccount, Account toAccount){
        double amountReceived = CurrencyService.convertCurrency(amountSent, fromAccount.getCurrency(), toAccount.getCurrency());

        Transfer transfer = new Transfer(amountSent, amountReceived, fromAccount, toAccount);

        fromAccount.setAmount(fromAccount.getAmount()-amountSent);
        toAccount.setAmount(toAccount.getAmount()+amountReceived);

        fromAccount.addTransfer(transfer);
        toAccount.addTransfer(transfer);
    }

}
