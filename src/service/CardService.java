package service;
import java.util.Random;

public class CardService {
    
    private static int cardCounter=0;

    public static String getNewCardNumber(){
        cardCounter+=1;
        return String.format("%016d", cardCounter);
    }

    public static String getNewCardSecurity(){
        Random rand = new Random();
        return String.format("%03d",rand.nextInt(1000));
    }

}
