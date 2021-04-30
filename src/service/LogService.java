package service;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogService {

    FileWriter file;
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());

    {
        try {
            file = new FileWriter("resources/outputs/methodLogs.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static LogService single_instance =null;

    private LogService(){}

    public static LogService getInstance()
    {
        if (single_instance == null)
            single_instance = new LogService();

        return single_instance;
    }

    public void logThis(String text){
        try {
            file.write(text + " "+ date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
