import java.util.Scanner;

public class TimeObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Time t1 = new Time();
        System.out.println("Default Time 1: " + t1);

        System.out.print("Enter hour, minute, and second for Time 2: ");
        int h2 = sc.nextInt();
        int m2 = sc.nextInt();
        int s2 = sc.nextInt();
        Time t2 = new Time(h2, m2, s2);
        System.out.println("Time 2: " + t2.toString());

        System.out.print("Enter new hour for Time 1: ");
        t1.setHour(sc.nextInt());
        System.out.print("Enter new minute for Time 1: ");
        t1.setMinute(sc.nextInt());
        System.out.print("Enter new second for Time 1: ");
        t1.setSecond(sc.nextInt());

        System.out.println("Time 1 Hour: " + t1.getHour());
        System.out.println("Time 1 Minute: " + t1.getMinute());
        System.out.println("Time 1 Second: " + t1.getSecond());

        System.out.print("Enter hour, minute, and second to set Time 2: ");
        int newH2 = sc.nextInt();
        int newM2 = sc.nextInt();
        int newS2 = sc.nextInt();
        t2.setTime(newH2, newM2, newS2);
        System.out.println("Updated Time 2: " + t2);

        System.out.println("Time 1 before nextSecond: " + t1);
        System.out.println("Time 1 after nextSecond: " + t1.nextSecond());

        sc.close();
    }
}

class Time{
    private int hour, minute, second;
    public Time(){
        hour = minute = second = 0;
    }
    public Time(int h, int m, int s){
        setTime(h, m, s);
    }
    public int getHour(){
        return hour;
    }
    public void setHour(int h){
        hour = h % 24;
    }
    public int getMinute(){
        return minute;
    }
    public void setMinute(int m){
        minute = m % 60;
    }
    public int getSecond(){
        return second;
    }
    public void setSecond(int s){
        second = s % 60;
    }
    public void setTime(int h, int m, int s){
        second = s % 60;
        minute = (m + s / 60) % 60;
        hour = (h + (m + s / 60) / 60) % 24;
    }
    public String toString(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    public Time nextSecond(){
        setTime(hour, minute, second + 1);
        return this;
    }
}
