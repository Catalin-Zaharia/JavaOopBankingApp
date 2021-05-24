package service;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUpdateService {

    private static DatabaseUpdateService single_instance =null;
    private Connection connection;

    private DatabaseUpdateService() throws SQLException {
        this.connection = DatabaseConnectionService.getConnection();
    }

    public static DatabaseUpdateService getInstance() throws SQLException {
        if (single_instance == null) {
            single_instance = new DatabaseUpdateService();
        }
        return single_instance;
    }

    public void updateUserById(int userid, String firstname, String lastname){
        try {
            connection.createStatement().executeUpdate("UPDATE users SET firstname='"+firstname+"', lastname='"+lastname+"' where id="+String.valueOf(userid));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }

    public void updateAccountByIBAN(String iban, int userid, int currencyid, int amount){
        iban="'"+iban+"'";
        try {
            connection.createStatement().executeUpdate("UPDATE accounts SET userid="+String.valueOf(userid)+", currencyid="+String.valueOf(currencyid)+", amount="+String.valueOf(amount)+" where iban="+iban);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }

    public void updateCurrencyById(int currencyid, String name, String code, float rate){
        name = "'" +name+ "'";
        code = "'" +code+ "'";
        String rateString = "'"+ String.valueOf(rate) + "'";
        try {
            connection.createStatement().executeUpdate("UPDATE currencies SET name="+name+", code="+code+", rate="+rateString+" where id="+String.valueOf(currencyid));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }

}
