package cl.tbd.back.repositories;

import cl.tbd.back.models.Task;

import java.util.List;

public interface TaskRepository {

    public List<Task> findAllTask();
    public Task findTask(int id);
    public int countTask();
    public Task createTask(Task task);
    public void updateTask(Task task, int id);
    public void deleteTask(int id);
}
