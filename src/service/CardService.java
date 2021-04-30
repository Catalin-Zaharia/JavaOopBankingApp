package service;
import model.Account;
import model.Card;
import model.CreditCard;
import model.DebitCard;

import java.util.Random;
import java.util.Scanner;

public class CardService {
    
    private int cardCounter=0;

    private Scanner scanner;

    private static CardService single_instance =null;

    private CardService(){}

    public static CardService getInstance()
    {
        if (single_instance == null)
            single_instance = new CardService();

        return single_instance;
    }
    
    public  String getNewCardNumber(){
        cardCounter+=1;
        return String.format("%016d", cardCounter);
    }

    public  String getNewCardSecurity(){
        Random rand = new Random();
        return String.format("%03d",rand.nextInt(1000));
    }

    public  void activateCard(Account account, String type){

        String number = CardService.getInstance().getNewCardNumber();
        String security = CardService.getInstance().getNewCardSecurity();
        if (type.equalsIgnoreCase("DEBIT")){
            account.addCard(new DebitCard(account, number, security));
            changePin(account, account.getLastCard());
        }
        else if(type.equalsIgnoreCase("CREDIT")){
            account.addCard(new CreditCard(account, number, security));
            changePin(account, account.getLastCard());
        }
        else{
            System.out.println("Eroare");
        }
    }

    public  void voidCard(Account account, int cardIndex){
        System.out.println("Doriti sa invalidati permanent cardul?");
        scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("DA")){
            account.removeCard(cardIndex);
            System.out.println("Cardul a fost invalidat");
        }
        else{
            System.out.println("Cardul nu a fost invalidat");
        }
    }

    public  void voidCard(Account account, Card card){
        System.out.println("Doriti sa invalidati permanent cardul?");
        scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("DA")){
            account.removeCard(card);
            System.out.println("Cardul a fost invalidat");
        }
        else{
            System.out.println("Cardul nu a fost invalidat");
        }
    }

    private  boolean isNumeric(String strNum) {
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

    public  void changePin(Account account, Card card){
        System.out.println("Care este pinul dorit? (4 cifre)");
        scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        if (isNumeric(response) && response.length()==4){
            card.setPin(response);
        }
        else{
            card.setPin("0000");
        }
    }

}
