package service;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogService {

    FileWriter file;
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());


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
            file = new FileWriter("resources/outputs/methodLogs.csv", true);
            file.write(text + " "+ date+'\n');
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
