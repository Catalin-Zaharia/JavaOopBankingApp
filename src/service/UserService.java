package service;

public class UserService {
    
    private static int idCounter=0;

    public static int getNewUserId(){
        idCounter+=1;
        return idCounter;
    }
}
