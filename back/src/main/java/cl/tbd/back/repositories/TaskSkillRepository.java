package cl.tbd.back.repositories;

import cl.tbd.back.models.TaskSkill;

import java.util.List;

public interface TaskSkillRepository {

    public List<TaskSkill> findAllTaskSkill();
    public TaskSkill findTaskSkill(int id);
    public int countTaskSkill();
    public TaskSkill createTaskSkill(TaskSkill taskSkill);
    public void updateTaskSkill(TaskSkill taskSkill, int id);
    public void deleteTaskSkill(int id);
}
