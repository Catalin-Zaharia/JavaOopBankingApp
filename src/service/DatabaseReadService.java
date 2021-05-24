package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseReadService {

    private static DatabaseReadService single_instance =null;
    private Connection connection;

    private DatabaseReadService() throws SQLException {
        this.connection = DatabaseConnectionService.getConnection();
    }

    public static DatabaseReadService getInstance() throws SQLException {
        if (single_instance == null) {
            single_instance = new DatabaseReadService();
        }
        return single_instance;
    }

    public String readUserById(int userId){
        String result = null;
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery("select firstname, lastname from users where id="+String.valueOf(userId));
            while (resultSet.next())
            result=resultSet.getString(1)+" "+resultSet.getString(2);
        }
        catch (SQLException throwables) {
            System.out.println("Actiunea nu a fost efectuata");
            throwables.printStackTrace();
        }
        return result;
    }

    public String readAccountByIBAN(String iban){
        String result = null;
        iban = "'"+iban+"'";
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery("select userid, currencyid, amount from accounts where iban="+iban);
            while (resultSet.next())
                result=resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3);
        }
        catch (SQLException throwables) {
            System.out.println("Actiunea nu a fost efectuata");
            throwables.printStackTrace();
        }
        return result;
    }

    public String readCurrencyByCode(String code){
        String result = null;
        ResultSet resultSet = null;
        code = "'"+code+"'";
        try {
            resultSet = connection.createStatement().executeQuery("select name from currencies where code="+code);
            while (resultSet.next())
                result=resultSet.getString(1);
        }
        catch (SQLException throwables) {
            System.out.println("Actiunea nu a fost efectuata");
            //throwables.printStackTrace();
        }
        return result;
    }


}
