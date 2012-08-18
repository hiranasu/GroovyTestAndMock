package jp.org.mhirakaw;

import java.util.Calendar;

public class GreetSupporter {
    
    public String greetByTime() {
        Calendar now = Calendar.getInstance();
        int nowHour = now.get(Calendar.HOUR_OF_DAY);
        
        if (nowHour >= 0 && nowHour < 5 || nowHour >= 18 && nowHour < 24) {
            return "Good evening";
        } else if (nowHour >= 5 && nowHour < 10) {
            return "Good morning";
        } else {
            return "hello";
        }
    }
}
