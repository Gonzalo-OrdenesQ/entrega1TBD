package cl.tbd.back.repositories;


import cl.tbd.back.models.TaskSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskSkillRepositoryImp implements TaskSkillRepository {

    @Autowired
    Sql2o sql2o;


    @Override
    public List<TaskSkill> findAllTaskSkill() {
        String select = "SELECT * FROM task_skill";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(TaskSkill.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public TaskSkill findTaskSkill(int id) {
        String select = "SELECT * FROM task_skill WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id",id)
                    .executeAndFetchFirst(TaskSkill.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countTaskSkill() {
        String count = "SELECT COUNT(*) FROM task_skill";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public TaskSkill createTaskSkill(TaskSkill taskSkill) {
        String insert = "INSERT INTO task_skill (id_task, id_skill)" +
                        "VALUES (:id_task, :id_skill)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert,true)
                    .addParameter("id_task", taskSkill.getId_task())
                    .addParameter("id_task", taskSkill.getId_skill())
                    .executeUpdate();
            return taskSkill;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateTaskSkill(TaskSkill taskSkill, int id) {
        String update = "UPDATE task_skill SET id_task = :id_task, id_skill = :id_skill, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("id_task", taskSkill.getId_task())
                    .addParameter("id_skill", taskSkill.getId_skill())
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteTaskSkill(int id) {
        String delete = "DELETE FROM task_skill WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
