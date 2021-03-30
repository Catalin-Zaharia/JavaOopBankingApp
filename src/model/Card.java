package model;

import java.time.LocalDate;

public class Card {
    
    private String number;
    private Account account;
    private String nameOnCard;
    private String security;
    private String pin;
    private LocalDate expiry;

    public Card(Account account, String number, String security) {
        this.account = account;
        this.number = number;
        this.nameOnCard = this.account.getOwner().getFirstName() +" "+ this.account.getOwner().getLastName();
        this.security= security;
        this.pin = "0000";
        this.expiry = LocalDate.now();
    }

    public String getNumber() {
        return number;
    }
   
    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public String getSecurity() {
        return security;
    }

    public String getName(){
        return this.nameOnCard;
    }

    public Account getAccount(){ 
        return this.account;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin){
        this.pin = pin;
    }
}
