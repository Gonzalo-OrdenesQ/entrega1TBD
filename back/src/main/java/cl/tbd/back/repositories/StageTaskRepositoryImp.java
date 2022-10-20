package cl.tbd.back.repositories;

import cl.tbd.back.models.StageTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class StageTaskRepositoryImp implements StageTaskRepository{

    @Autowired
    Sql2o sql2o;


    @Override
    public List<StageTask> findAllStageTask() {
        String select = "SELECT * FROM stage_task";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(StageTask.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public StageTask findStageTask(int id) {
        String select = "SELECT * FROM stage_task WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id", id)
                    .executeAndFetchFirst(StageTask.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countStageTask() {
        String count = "SELECT COUNT(*) FROM stage_task";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public StageTask createStageTask(StageTask stageTask) {
        String insert = "INSERT INTO stage_task (stage) " +
                        "VALUES (:stage)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert, true)
                    .addParameter("stage", stageTask.getStage())
                    .executeUpdate();
            return stageTask;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateStageTask(StageTask stageTask, int id) {
        String update = "UPDATE stage_task SET stage = :stage, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("stage", stageTask.getStage())
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStageTask(int id) {
        String delete = "DELETE FROM stage_task WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
