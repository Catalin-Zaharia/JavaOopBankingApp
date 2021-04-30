package model;

import service.UserService;

public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private UserService service = UserService.getInstance();

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = service.getNewUserId();
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getId(){
        return this.id;
    }
}
