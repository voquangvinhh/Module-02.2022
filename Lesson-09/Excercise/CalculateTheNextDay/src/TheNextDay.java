public class TheNextDay {
    public static String getNextDay(int day, int month, int year){
        return ++day + "/" + month + "/" + year;
    }

    public static String getLastDayMonth(int day, int month, int year){
        if (day == 31){
            day = 1;
            month++;
        }
        else {
            day++;
        }
        return day + "/" + month + "/" + year;
    }

    public static String getLast30DayMonth(int day, int month, int year){
        if (day == 30){
            day = 1;
            month++;
        }
        else {
            day++;
        }
        return day + "/" + month + "/" + year;
    }

    public static String getMonth2(int day, int month, int year){
        if (day == 28 || day == 29){
            day = 1;
            month++;
        }
        else {
            day++;
        }
        return day + "/" + month + "/" + year;
    }

    public static String getLastDayOfYear(int day, int month, int year){
        if (day == 31 && month == 12){
            day = 1;
            month = 1;
            year++;
        }
        else {
            day ++;
        }
        return day + "/" + month + "/" + year;
    }
}
