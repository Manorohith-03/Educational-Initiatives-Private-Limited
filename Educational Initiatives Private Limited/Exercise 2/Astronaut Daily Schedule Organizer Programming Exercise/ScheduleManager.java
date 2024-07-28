import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class ScheduleManager extends Observable {
    private static ScheduleManager instance;
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) throws Exception {
        for (Task t : tasks) {
            if (task.getStartTime().equals(t.getStartTime()) && task.getEndTime().equals(t.getEndTime())) {
                if (getPriorityValue(task.getPriority()) > getPriorityValue(t.getPriority())) {
                    tasks.remove(t);
                    tasks.add(task);
                    tasks.sort(Comparator.comparing(Task::getStartTime));
                    setChanged();
                    notifyObservers(new ConflictInfo(task, t));
                    return;
                } else {
                    throw new Exception("Task conflicts with existing task \"" + t.getDescription() + "\" and has lower or equal priority.");
                }
            } else if (task.getStartTime().before(t.getEndTime()) && task.getEndTime().after(t.getStartTime())) {
                throw new Exception("Task conflicts with existing task \"" + t.getDescription() + "\".");
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
    }

    private int getPriorityValue(String priority) {
        switch (priority.toLowerCase()) {
            case "high":
                return 3;
            case "medium":
                return 2;
            case "low":
                return 1;
            default:
                return 0;
        }
    }

    public void removeTask(String description) throws Exception {
        boolean found = false;
        for (Iterator<Task> iterator = tasks.iterator(); iterator.hasNext();) {
            Task t = iterator.next();
            if (t.getDescription().equals(description)) {
                iterator.remove();
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Task not found.");
        }
    }

    public List<Task> viewTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> viewTasksByPriority(String priority) {
        List<Task> priorityTasks = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getPriority().equals(priority)) {
                priorityTasks.add(t);
            }
        }
        return priorityTasks;
    }
}
