package model;

public class DebitCard extends Card {

    private boolean acceptLoans;

    public DebitCard(Account account, String number, String security){
        super(account, number, security);
        this.acceptLoans=false;
    }

    public boolean isAcceptLoans() {
        return acceptLoans;
    }

    public void setAcceptLoans(boolean acceptLoans) {
        this.acceptLoans = acceptLoans;
    }
}
