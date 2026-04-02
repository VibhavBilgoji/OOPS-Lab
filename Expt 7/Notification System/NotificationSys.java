import java.util.Scanner;

public class NotificationSys{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Select Notification Type:");
            System.out.println("1. Email Notification");
            System.out.println("2. SMS Notification");
            System.out.println("3. Push Notification");
            System.out.println("0. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = sc.nextInt();
            Notification notification;
            switch(choice){
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                case 1:
                    notification = new EmailNotification();
                    break;
                case 2:
                    notification = new SMSNotification();
                    break;
                case 3:
                    notification = new PushNotification();
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Generic Notification.");
                    notification = new Notification();
            }
            notification.send();
        }
    }
}

class Notification{
    public void send(){
        System.out.println("Sending Generic Notification...\n");
    };
}

class EmailNotification extends Notification{
    @Override
    public void send(){
        System.out.println("Sending Email Notification...\n");
    }
}

class SMSNotification extends Notification{
    @Override
    public void send(){
        System.out.println("Sending SMS Notification...\n");
    }
}

class PushNotification extends Notification{
    @Override
    public void send(){
        System.out.println("Sending Push Notification...\n");
    }
}