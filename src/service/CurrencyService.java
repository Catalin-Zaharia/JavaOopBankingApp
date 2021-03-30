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

    public static void printTransfer(Transfer transfer){
        double amountSent= transfer.getAmountSent();
        double amountReceived = transfer.getAmountReceived();
        String fromUser = transfer.getFromAccount().getOwner().getFirstName()+" "+transfer.getFromAccount().getOwner().getLastName();
        String toUser = transfer.getToAccount().getOwner().getFirstName()+" "+transfer.getToAccount().getOwner().getLastName();
        System.out.println(String.format(fromUser+" a trimis %f catre "+toUser+ " | "+toUser+" a primit %f de la "+fromUser, amountSent, amountReceived));
    }

}
