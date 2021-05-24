package service;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseDeleteService {

    private static DatabaseDeleteService single_instance =null;
    private Connection connection;

    private DatabaseDeleteService() throws SQLException {
        this.connection = DatabaseConnectionService.getConnection();
    }

    public static DatabaseDeleteService getInstance() throws SQLException {
        if (single_instance == null) {
            single_instance = new DatabaseDeleteService();
        }
        return single_instance;
    }

    public void deleteUserById(int userid){
        try {
            connection.createStatement().executeUpdate("DELETE from users where id="+String.valueOf(userid));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }

    public void deleteAccountByIBAN(String iban){
        iban="'" + iban+ "'";
        try {
            connection.createStatement().executeUpdate("DELETE from accounts where iban="+iban);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }

    public void deleteCurrencyById(int currencyid){
        try {
            connection.createStatement().executeUpdate("DELETE from currencies where id="+String.valueOf(currencyid));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }
}
