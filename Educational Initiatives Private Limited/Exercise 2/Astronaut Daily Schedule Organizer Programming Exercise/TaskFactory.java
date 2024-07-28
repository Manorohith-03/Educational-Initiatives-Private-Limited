import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskFactory {
    public Task createTask(String description, String startTime, String endTime, String priority) throws ParseException, IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);
        
        Date start;
        Date end;
        
        try {
            start = sdf.parse(startTime);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid start time format.");
        }
        
        try {
            end = sdf.parse(endTime);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid end time format.");
        }
        
        if (end.before(start)) {
            throw new IllegalArgumentException("End time must be after start time.");
        }
        
        return new Task(description, start, end, priority);
    }
}