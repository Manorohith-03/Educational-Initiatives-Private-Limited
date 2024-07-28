public interface Observer {
    void update(Task newTask, Task existingTask);
}