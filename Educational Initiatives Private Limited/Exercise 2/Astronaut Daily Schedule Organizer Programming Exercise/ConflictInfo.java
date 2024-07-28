public class ConflictInfo {
    private Task newTask;
    private Task existingTask;

    public ConflictInfo(Task newTask, Task existingTask) {
        this.newTask = newTask;
        this.existingTask = existingTask;
    }

    public Task getNewTask() {
        return newTask;
    }

    public Task getExistingTask() {
        return existingTask;
    }
}