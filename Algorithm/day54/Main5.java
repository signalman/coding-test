package Algorithm.day54;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main5 {

    public static void main(String[] args) {
        LocalTime startTime = LocalTime.of(9, 0, 0);
        LocalTime endTime = LocalTime.of(10, 10, 1);
        long hors = ChronoUnit.HOURS.between(startTime, endTime);
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime);
        long sec = ChronoUnit.SECONDS.between(startTime, endTime);
        System.out.println(hors);
        System.out.println(minutes % 60);
        System.out.println(sec% 60) ;

    }

}
