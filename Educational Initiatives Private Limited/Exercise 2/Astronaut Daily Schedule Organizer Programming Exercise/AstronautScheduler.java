import java.util.List;
import java.util.Scanner;

public class AstronautScheduler {
    private static Scanner scanner = new Scanner(System.in);
    private static TaskFactory taskFactory = new TaskFactory();
    private static ScheduleManager scheduleManager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        scheduleManager.addObserver(new ConflictObserver());
        showMenu();
    }

    private static void showMenu() {
        System.out.println("Choose an option: ");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. View Tasks by Priority");
        System.out.println("5. Exit");

        int choice = getUserChoice();
        handleChoice(choice);
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please try again.");
                return getUserChoice();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            return getUserChoice();
        }
        return choice;
    }

    private static void handleChoice(int choice) {
        if (choice == 1) {
            addTask();
        } else if (choice == 2) {
            removeTask();
        } else if (choice == 3) {
            viewAllTasks();
        } else if (choice == 4) {
            viewTasksByPriority();
        } else if (choice == 5) {
            System.exit(0);
        }
        showMenu();
    }

    private static void addTask() {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        try {
            Task task = taskFactory.createTask(description, startTime, endTime, priority);
            scheduleManager.addTask(task);
            System.out.println("Task added successfully. No conflicts.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeTask() {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine();
        
        try {
            scheduleManager.removeTask(description);
            System.out.println("Task removed successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllTasks() {
        List<Task> tasks = scheduleManager.viewTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }

    private static void viewTasksByPriority() {
        System.out.print("Enter priority level to view (High/Medium/Low): ");
        String priority = scanner.nextLine();
        List<Task> tasks = scheduleManager.viewTasksByPriority(priority);
        
        if (tasks.isEmpty()) {
            System.out.println("No tasks with priority level " + priority + ".");
        } else {
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }
}
