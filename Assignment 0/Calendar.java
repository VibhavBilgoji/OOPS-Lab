import java.util.Scanner;

public class Calendar{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Default Date: " + new Date().toString());

        System.out.println("Enter day, month, and year for Date 1:");
        int day1 = sc.nextInt();
        int month1 = sc.nextInt();
        int year1 = sc.nextInt();
        Date date1 = new Date(day1, month1, year1);

        System.out.println("Enter day, month, and year for Date 2:");
        int day2 = sc.nextInt();
        int month2 = sc.nextInt();
        int year2 = sc.nextInt();
        Date date2 = new Date();
        date2.setDate(day2, month2, year2);

        System.out.println("Date 1: " + date1.toString());

        System.out.println("Date 2 - Day: " + date2.getDay());
        System.out.println("Date 2 - Month: " + date2.getMonth());
        System.out.println("Date 2 - Year: " + date2.getYear());

        System.out.println("Enter new day, month, and year for Date 2:");
        date2.setDay(sc.nextInt());
        date2.setMonth(sc.nextInt());
        date2.setYear(sc.nextInt());
        System.out.println("Date 2 (after setting new values): " + date2);

        sc.close();
    }
}

class Date{
    private int day, month, year;
    public Date(int d, int m, int y){
        setDate(d, m, y);
    }
    public Date(){
        day = month = year = 0;
    }
    public int getDay(){
        return day;
    }
    public void setDay(int d){
        day = d;
    }
    public int getMonth(){
        return month;
    }
    public void setMonth(int m){
        month = m;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int y){
        year = y;
    }
    public void setDate(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }
    public String toString(){
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
