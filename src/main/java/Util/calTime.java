package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by huangweichen on 2017/8/1.
 */
public class calTime {

    public static void calTimeDiff(Long ts1, Long ts2){
        Double diffMin = (ts2 - ts1 + 0.0) / (1000 * 60);
        System.out.printf("time diff: %f mins");
    }

    public static Long getTimeLong(){
        return Calendar.getInstance().getTimeInMillis();
    }

    public static String getTimeLongStr(){
        return Long.toString(Calendar.getInstance().getTimeInMillis());
    }

    public static String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd"); // "yyyy-MM-dd HH:mm:ss"
        Date date = Calendar.getInstance().getTime();
        // String dateStr = df.format(date);
        return df.format(date);
    }

    public static String getTimeToSec(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss"); // "yyyy-MM-dd HH:mm:ss"
        Date date = Calendar.getInstance().getTime();
        // String dateStr = df.format(date);
        return df.format(date);
    }

}
