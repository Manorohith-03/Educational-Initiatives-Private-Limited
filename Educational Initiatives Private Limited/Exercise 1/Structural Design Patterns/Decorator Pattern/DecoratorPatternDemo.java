import java.util.Scanner;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Coffee coffee = new SimpleCoffee();

            System.out.println("Enter the number of condiments to add (max 3):");
            int numCondiments = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numCondiments; i++) {
                System.out.println("Choose a condiment to add (Milk, Soy, Mocha):");
                String choice = scanner.nextLine();
                switch (choice.toLowerCase()) {
                    case "milk":
                        coffee = new MilkDecorator(coffee);
                        break;
                    case "soy":
                        coffee = new SoyDecorator(coffee);
                        break;
                    case "mocha":
                        coffee = new MochaDecorator(coffee);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        i--;
                }
            }

            System.out.println(coffee.getDescription() + " $" + coffee.cost());
        }
    }
}

/*Sample Input:
    Enter the number of condiments to add (max 3):2
    Choose a condiment to add (Milk, Soy, Mocha):Milk
    Choose a condiment to add (Milk, Soy, Mocha):Soy
Output:
    Simple Coffee, Milk, Soy $7.5
 */