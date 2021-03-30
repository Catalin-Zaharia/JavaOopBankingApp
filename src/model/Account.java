package model;

import java.util.ArrayList;

public class Account {
    
    private String iban;
    private User owner;
    private Currency currency;
    private double amount;
    private ArrayList<Card> cards;
    private ArrayList<Transfer> transfers;
    
    public Account(User owner, Currency currency, double startingAmount, String iban) {
        this.owner = owner;
        this.currency = currency;
        this.setAmount(startingAmount);
        this.iban =iban;
        this.cards= new ArrayList<Card>();
        this.transfers = new ArrayList<Transfer>();
    }

    public ArrayList<Card> getAllCards() {
        return cards;
    }

    public Card getLastCard(){
        if (cards.size()>0){
        return cards.get(cards.size()-1);
        }
        return null;
    }

    public void removeCard(int index){
        cards.remove(index);
    }
    public void removeCard(Card card){
        cards.remove(card);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }


    public Currency getCurrency() {
        return currency;
    }

    public User getOwner() {
        return owner;
    }

    public String getIban() {
        return iban;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }

    public void addTransfer(Transfer transfer) {
        this.transfers.add(transfer);
    }
}
