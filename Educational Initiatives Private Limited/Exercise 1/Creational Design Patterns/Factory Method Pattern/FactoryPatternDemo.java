import java.util.Scanner;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            NotificationFactory factory = new NotificationFactory();

            System.out.println("Enter notification type (EMAIL, SMS, PUSH): ");
            String type = scanner.nextLine();

            Notification notification = factory.createNotification(type);
            if (notification != null) {
                notification.notifyUser();
            } else {
                System.out.println("Invalid notification type");
            }
        }
    }
}

/*Sample Input:
    Enter notification type (EMAIL, SMS, PUSH): EMAIL
Output:
    Sending an email notification
 */