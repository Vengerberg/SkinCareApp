package manager;

import java.time.LocalTime;

public class TimeManager {


    public static boolean alertTime(String time) {
        LocalTime t = LocalTime.parse(time);
        LocalTime t2 = LocalTime.now();

        if(t.isBefore(t2)) {
            return true;
        }

        return false;
    }
}