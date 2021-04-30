package service;

import model.Account;
import model.Transfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransferService {

    private static TransferService single_instance =null;

    private  Scanner scanner;

    private TransferService(){}

    public static TransferService getInstance()
    {
        if (single_instance == null)
            single_instance = new TransferService();

        return single_instance;
    }

    public void makeTransfer(double amountSent, Account fromAccount, Account toAccount){
        double amountReceived = CurrencyService.getInstance().convertCurrency(amountSent, fromAccount.getCurrency(), toAccount.getCurrency());

        Transfer transfer = new Transfer(amountSent, amountReceived, fromAccount, toAccount);

        fromAccount.setAmount(fromAccount.getAmount()-amountSent);
        toAccount.setAmount(toAccount.getAmount()+amountReceived);

        fromAccount.addTransfer(transfer);
        toAccount.addTransfer(transfer);
    }

    public void printTransfer(Transfer transfer){
        double amountSent= transfer.getAmountSent();
        double amountReceived = transfer.getAmountReceived();
        String fromUser = transfer.getFromAccount().getOwner().getFirstName()+" "+transfer.getFromAccount().getOwner().getLastName();
        String toUser = transfer.getToAccount().getOwner().getFirstName()+" "+transfer.getToAccount().getOwner().getLastName();
        System.out.printf(fromUser + " a trimis %f catre " + toUser + " | " + toUser + " a primit %f de la " + fromUser + "%n", amountSent, amountReceived);
    }

    public  void transferFunds(double amountSent, Account fromAccount, Account toAccount){
        if (fromAccount.getAmount()>=amountSent){
            System.out.printf("Doriti sa transferati %f catre "+toAccount.getOwner().getFirstName()+ " "+ toAccount.getOwner().getLastName()+ "?%n", amountSent);
            scanner = new Scanner(System.in);
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("DA")){

                TransferService.getInstance().makeTransfer(amountSent, fromAccount, toAccount);

                System.out.println("Transferul a fost efectuat");
            }
            else{
                System.out.println("Transferul nu a putut fi efectuat");
            }
        }
        else{
            System.out.println("Nu aveti fonduri suficiente pentru a efectua transferul");
        }
    }

    public  void bulkTransfer(double amountSent, Account fromAccount, ArrayList<Account> toAccounts){
        if (fromAccount.getAmount()>=amountSent*toAccounts.size()){
            System.out.printf("Doriti sa transferati cate %f catre persoanele din lista?%n", amountSent);
            scanner = new Scanner(System.in);
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("DA")){

                for (Account toAccount : toAccounts) {
                    TransferService.getInstance().makeTransfer(amountSent, fromAccount, toAccount);
                }
                System.out.println("Transferul a fost efectuat");
            }
            else{
                System.out.println("Transferul nu a putut fi efectuat");
            }
        }
        else{
            System.out.println("Nu aveti fonduri suficiente pentru a efectua transferul");
        }
    }

    public  void getAllTransfers(Account account){
        List<Transfer> transfers = account.getTransfers();

        for (Transfer transfer : transfers) {
            TransferService.getInstance().printTransfer(transfer);
        }
    }

}
