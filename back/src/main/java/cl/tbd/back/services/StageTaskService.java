package cl.tbd.back.services;

import cl.tbd.back.models.StageTask;
import cl.tbd.back.repositories.StageTaskRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageTaskService {

    @Autowired
    StageTaskRepositoryImp stageTaskRepository;

    public List<StageTask> getAll(){
        return stageTaskRepository.findAllStageTask();
    }

    public StageTask select(int id){
        return stageTaskRepository.findStageTask(id);
    }

    public int count(){
        return stageTaskRepository.countStageTask();
    }

    public StageTask createStageTask(StageTask stagetask){
        return stageTaskRepository.createStageTask(stagetask);
    }

    public void updateStageTask(StageTask stageTask, int id){
        stageTaskRepository.updateStageTask(stageTask, id);
    }

    public void deleteStageTask(int id){
        stageTaskRepository.deleteStageTask(id);
    }
}
