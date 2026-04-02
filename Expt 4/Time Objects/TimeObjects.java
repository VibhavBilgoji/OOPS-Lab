import java.util.Scanner;

public class TimeObjects{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Time objects: ");
        int n = sc.nextInt();
        Time[] times = new Time[n];
        for(int i = 1; i <= n; i++){
            System.out.print("Enter hours, minutes and seconds for Time object " + i + ": ");
            int h = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt();
            times[i-1] = new Time(h, m, s);
        }
        sc.close();
        System.out.println("\nTime objects created:");
        for(int i = 0; i < n; i++){
            System.out.println("Time object " + (i+1) + ": " + times[i].toString());
        }
    }
}

class Time{
    private int hours, minutes, seconds;
    public Time(int h, int m, int s){
        seconds = s % 60;
        minutes = (m + s / 60) % 60;
        hours = (h + (m + s / 60) / 60) % 24;
    }
    public Time(){
        hours = minutes = seconds = 0;
    }
    public int getHours(){
        return hours;
    }
    public void setHours(int hours){
        this.hours = hours % 24;
    }
    public int getMinutes(){
        return minutes;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes % 60;
    }
    public int getSeconds(){
        return seconds;
    }
    public void setSeconds(int seconds){
        this.seconds = seconds % 60;
    }
    public String toString(){
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}