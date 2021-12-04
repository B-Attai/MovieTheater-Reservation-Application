package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Helper class to get current time
public class DateTime {

    DateTimeFormatter dtf;
    LocalDateTime now;

    public DateTime(){
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        now = LocalDateTime.now();
    }

    public String getCurrentDateTime(){
        return dtf.format(now);
    }
}
