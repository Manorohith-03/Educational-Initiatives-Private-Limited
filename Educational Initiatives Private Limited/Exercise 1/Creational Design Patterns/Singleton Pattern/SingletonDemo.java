import java.util.Scanner;

public class SingletonDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Logger logger = Logger.getInstance();

            System.out.println("Enter a log message: ");
            String message = scanner.nextLine();

            logger.log(message);
        }
    }
}

/*Sample Input:
    Enter a log message: This is a log message.
Output:
    Log: This is a log message.
 */