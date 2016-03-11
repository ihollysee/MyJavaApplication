
package ijava.util;

import java.util.Calendar;

public class CalendarTest {

    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());

        int nowMonth = c.get(Calendar.MONTH);
        int nowDay = c.get(Calendar.DAY_OF_MONTH);
        int nowDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int nowHour = c.get(Calendar.HOUR_OF_DAY);
        int nowMinute = c.get(Calendar.MINUTE);
        System.out.println(nowMonth + "," + nowDay + ",nowDayOfWeek:" + nowDayOfWeek + ","
                + nowHour + "," +
                nowMinute);
        System.out.println(c.getTime().toLocaleString());

        c.add(Calendar.MONTH, 1);

        System.out.println(c.get(Calendar.MONTH) + "," + nowDay + "," + nowHour + "," + nowMinute);
        System.out.println(c.getTime().toLocaleString());

        c.add(Calendar.DAY_OF_WEEK, 1);
        c.add(Calendar.DAY_OF_YEAR, 1);

        System.out.println(c.get(Calendar.MONTH) + ",DayOfWeek:" + c.get(Calendar.DAY_OF_WEEK)
                + ",DayOfMonth:" + c.get(Calendar.DAY_OF_MONTH) + ","
                + nowHour + "," + nowMinute);
        System.out.println(c.getTime().toLocaleString());
        // System.out.println(Calendar.JANUARY + "," + Calendar.FEBRUARY + "," +
        // Calendar.MARCH);
    }
}
