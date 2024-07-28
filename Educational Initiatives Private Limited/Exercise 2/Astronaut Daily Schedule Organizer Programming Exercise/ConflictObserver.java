import java.util.Observer;
import java.util.Observable;

public class ConflictObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ConflictInfo) {
            ConflictInfo info = (ConflictInfo) arg;
            System.out.println("Conflict detected: New task \"" + info.getNewTask().getDescription() + 
                               "\" conflicts with existing task \"" + info.getExistingTask().getDescription() + "\".");
        }
    }
}