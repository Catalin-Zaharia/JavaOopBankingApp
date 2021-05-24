package service;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseCreateService {

    private static DatabaseCreateService single_instance =null;
    private Connection connection;

    private DatabaseCreateService() throws SQLException {
        this.connection = DatabaseConnectionService.getConnection();
    }

    public static DatabaseCreateService getInstance() throws SQLException {
        if (single_instance == null) {
            single_instance = new DatabaseCreateService();
        }
        return single_instance;
    }

    public void addUser(String firstname, String lastname){
        firstname = "'"+firstname+"'";
        lastname = "'"+lastname+"'";
        try {
            connection.createStatement().executeUpdate("INSERT INTO users VALUES (NULL, "+firstname+", "+lastname+")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }

    public void addAccount(String iban, int userid, int currencyid, int amount){
        iban="'"+iban+"'";
        try {
            connection.createStatement().executeUpdate("INSERT INTO accounts VALUES (NULL, "+iban+", '"+String.valueOf(userid)+"', '"+String.valueOf(currencyid)+"', '"+String.valueOf(amount)+"')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }

    public void addCurrency(String code, String name, float rate){
        name="'"+name+"'";
        code="'"+code+"'";
        String rateString = "'"+String.valueOf(rate)+"'";
        try {
            connection.createStatement().executeUpdate("INSERT INTO currencies VALUES (NULL,"+code+", "+name+", "+rateString+")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Actiunea nu a fost efectuata");
        }
    }

}
