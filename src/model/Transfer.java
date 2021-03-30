package model;

import java.time.LocalDateTime;

public class Transfer {

    private LocalDateTime localDateTime;
    private Account fromAccount;
    private Account toAccount;
    private double amountSent;
    private double amountReceived;

    public Transfer(double amountSent, double amountReceived, Account fromAccount, Account toAccount){
        this.amountSent= amountSent;
        this.amountReceived= amountReceived;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.localDateTime = LocalDateTime.now();
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmountSent() {
        return amountSent;
    }

    public void setAmountSent(double amountSent) {
        this.amountSent = amountSent;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }
}
