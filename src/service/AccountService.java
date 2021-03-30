package service;

import model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

public class AccountService {
    
    private static Scanner scanner;

    public static Account createAccount(User user, Currency currency, double startingAmount){
        Random rand = new Random();
        String iban = String.format("RO00BANK292fa1904h9x%d", rand.nextInt(1000));
        return new Account(user, currency, startingAmount, iban);
    }

    public static void voidAccount(Account account){
        account = null;
    }

    public static void activateCard(Account account, String type){
        
        String number = CardService.getNewCardNumber();
        String security = CardService.getNewCardSecurity();
        if (type.equalsIgnoreCase("DEBIT")){
        account.addCard(new DebitCard(account, number, security));
        changePin(account, account.getLastCard());
        }
        else if(type.equalsIgnoreCase("CREDIT")){
        account.addCard(new CreditCard(account, number, security));
        changePin(account, account.getLastCard());
        }
        else{
            out.println("Eroare");
        }
    }

    public static void voidCard(Account account, int cardIndex){
        out.println("Doriti sa invalidati permanent cardul?");
        scanner = new Scanner(in);
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("DA")){
            account.removeCard(cardIndex);
            out.println("Cardul a fost invalidat");
        }
        else{
            out.println("Cardul nu a fost invalidat");
        }
    }

    public static void voidCard(Account account, Card card){
        out.println("Doriti sa invalidati permanent cardul?");
        scanner = new Scanner(in);
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("DA")){
            account.removeCard(card);
            out.println("Cardul a fost invalidat");
        }
        else{
            out.println("Cardul nu a fost invalidat");
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void changePin(Account account, Card card){
        out.println("Care este pinul dorit? (4 cifre)");
        scanner = new Scanner(in);
        String response = scanner.nextLine();

        if (isNumeric(response) && response.length()==4){
            card.setPin(response);
        }
        else{
            card.setPin("0000");
        }
    }

    public static void transferFunds(double amountSent, Account fromAccount, Account toAccount){
        if (fromAccount.getAmount()>=amountSent){
            out.println(String.format("Doriti sa transferati %f catre "+toAccount.getOwner().getFirstName()+ " "+ toAccount.getOwner().getLastName()+"?", amountSent));
            scanner = new Scanner(in);
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("DA")){

                CurrencyService.makeTransfer(amountSent, fromAccount, toAccount);

                out.println("Transferul a fost efectuat");
            }
            else{
                out.println("Transferul nu a putut fi efectuat");
            }
        }
        else{
            out.println("Nu aveti fonduri suficiente pentru a efectua transferul");
        }
    }

    public static void bulkTransfer(double amountSent, Account fromAccount, ArrayList<Account> toAccounts){
        if (fromAccount.getAmount()>=amountSent*toAccounts.size()){
            out.println(String.format("Doriti sa transferati cate %f catre persoanele din lista?", amountSent));
            scanner = new Scanner(in);
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("DA")){

                for (int i=0; i<toAccounts.size();i++) {
                    CurrencyService.makeTransfer(amountSent, fromAccount, toAccounts.get(i));
                }
                out.println("Transferul a fost efectuat");
            }
            else{
                out.println("Transferul nu a putut fi efectuat");
            }
        }
        else{
            out.println("Nu aveti fonduri suficiente pentru a efectua transferul");
        }
    }

    public static void getAllTransfers(Account account){
        ArrayList<Transfer> transfers = account.getTransfers();

        for (int i=0; i<transfers.size(); i++){
            CurrencyService.printTransfer(transfers.get(i));
        }
    }
}
