package cl.tbd.back.services;

import cl.tbd.back.models.Task;
import cl.tbd.back.repositories.TaskRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepositoryImp taskRepository;

    public List<Task> getAll(){
        return taskRepository.findAllTask();
    }

    public Task select(int id){
        return taskRepository.findTask(id);
    }

    public int count(){
        return taskRepository.countTask();
    }

    public Task createTask(Task task){
        return taskRepository.createTask(task);
    }

    public void updateSkill(Task task, int id){
        taskRepository.updateTask(task,id);
    }

    public void deleteSkill(int id){
        taskRepository.deleteTask(id);
    }
}
