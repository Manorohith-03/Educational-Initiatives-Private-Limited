import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ShoppingCart cart = new ShoppingCart();

            System.out.println("Enter amount to pay: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Choose payment method (1 for Credit Card, 2 for PayPal, 3 for Bitcoin): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Credit Card Number: ");
                    String cardNumber = scanner.nextLine();
                    cart.setPaymentStrategy(new CreditCardStrategy(cardNumber));
                    break;
                case 2:
                    System.out.println("Enter PayPal Email: ");
                    String emailId = scanner.nextLine();
                    cart.setPaymentStrategy(new PayPalStrategy(emailId));
                    break;
                case 3:
                    System.out.println("Enter Bitcoin Address: ");
                    String bitcoinAddress = scanner.nextLine();
                    cart.setPaymentStrategy(new BitcoinStrategy(bitcoinAddress));
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

            cart.checkout(amount);
        }
    }
}

/*Sample input:
    Enter amount to pay: 100
    Choose payment method (1 for Credit Card, 2 for PayPal, 3 for Bitcoin): 1
    Enter Credit Card Number: 1234567890123456
Output:
    100 paid with credit card.
 */