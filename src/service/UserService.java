package service;

public class UserService {
    
    private int idCounter;

    private static UserService single_instance =null;

    private UserService(){
        this.idCounter=0;
    }

    public static UserService getInstance()
    {
        if (single_instance == null)
            single_instance = new UserService();

        return single_instance;
    }
    
    public int getNewUserId(){
        idCounter+=1;
        return idCounter;
    }
}
