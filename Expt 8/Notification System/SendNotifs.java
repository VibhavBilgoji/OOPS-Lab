import java.util.Scanner;

public class SendNotifs{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Select the type of notification to send:");
            System.out.println("1. Email Notification");
            System.out.println("2. SMS Notification");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            Notification notif;
            switch(choice){
                case 1:
                    notif = new EmailNotification();
                    notif.send();
                    break;
                case 2:
                    notif = new SMSNotification();
                    notif.send();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }
}

abstract class Notification{
    abstract void send();
    final void logNotification(){
        System.out.println("Notification sent at: " + java.time.LocalDateTime.now() + "\n");
    }
}

class EmailNotification extends Notification{
    @Override
    void send(){
        System.out.println("Sending Email Notification...");
        logNotification();
    }
}

class SMSNotification extends Notification{
    @Override
    void send(){
        System.out.println("Sending SMS Notification...");
        logNotification();
    }
}