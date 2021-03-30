package model;

public class CreditCard extends Card {

    private double creditLine;
    private boolean acceptLoans;

    public CreditCard(Account account, String number, String security){
        super(account, number, security);
        this.acceptLoans=true;
        this.creditLine=1000;
    }

    public boolean isAcceptLoans() {
        return acceptLoans;
    }

    public void setAcceptLoans(boolean acceptLoans) {
        this.acceptLoans = acceptLoans;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }
}
