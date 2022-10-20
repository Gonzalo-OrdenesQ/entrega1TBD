package cl.tbd.back.repositories;

import cl.tbd.back.models.StageTask;

import java.util.List;

public interface StageTaskRepository {

    public List<StageTask> findAllStageTask();
    public StageTask findStageTask(int id);
    public int countStageTask();
    public StageTask createStageTask(StageTask stageTask);
    public void updateStageTask(StageTask stageTask, int id);
    public void deleteStageTask(int id);
}
