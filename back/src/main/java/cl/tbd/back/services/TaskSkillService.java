package cl.tbd.back.services;

import cl.tbd.back.models.TaskSkill;
import cl.tbd.back.repositories.TaskSkillRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskSkillService {

    @Autowired
    TaskSkillRepositoryImp taskSkillRepository;

    public List<TaskSkill> getAll(){
        return taskSkillRepository.findAllTaskSkill();
    }

    public TaskSkill select(int id){
        return taskSkillRepository.findTaskSkill(id);
    }

    public int count(){
        return taskSkillRepository.countTaskSkill();
    }

    public TaskSkill createTaskSkill(TaskSkill taskSkill){
        return taskSkillRepository.createTaskSkill(taskSkill);
    }

    public void updateTaskSkill(TaskSkill taskSkill, int id){
        taskSkillRepository.updateTaskSkill(taskSkill,id);
    }

    public void deleteTaskSkill(int id){
        taskSkillRepository.deleteTaskSkill(id);
    }
}
