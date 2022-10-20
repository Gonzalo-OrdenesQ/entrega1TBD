package cl.tbd.back.repositories;

import cl.tbd.back.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskRepositoryImp implements TaskRepository{

    @Autowired
    Sql2o sql2o;

    @Override
    public List<Task> findAllTask() {
        String select = "SELECT * FROM task";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(Task.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Task findTask(int id) {
        String select = "SELECT * FROM task WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Task.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countTask() {
        String count = "SELECT COUNT(*) FROM task";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Task createTask(Task task) {
        String insert = "INSERT INTO task (name, description, id_emergency, id_stage_task) " +
                        "VALUES (:name, :description, :id_emergency, :id_stage_task)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert, true)
                    .addParameter("name", task.getName())
                    .addParameter("description", task.getDescription())
                    .addParameter("id_emergency", task.getId_emergency())
                    .addParameter("id_stage_task", task.getId_stage_task())
                    .executeUpdate();
            return task;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateTask(Task task, int id) {
        String update = "UPDATE task SET name = :name, description = :description, id_emergency = :id_emergency, id_stage_task = :id_stage_task, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("name", task.getName())
                    .addParameter("description", task.getDescription())
                    .addParameter("id_emergency", task.getId_emergency())
                    .addParameter("id_stage_task", task.getId_stage_task())
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteTask(int id) {
        String delete = "DELETE FROM task WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id",id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
