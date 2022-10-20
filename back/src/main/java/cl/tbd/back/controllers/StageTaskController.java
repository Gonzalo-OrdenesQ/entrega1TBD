package cl.tbd.back.controllers;

import cl.tbd.back.models.StageTask;
import cl.tbd.back.services.StageTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/stage_task")
public class StageTaskController {

    @Autowired
    StageTaskService stageTaskService;

    @GetMapping("")
    public List<StageTask> getAll(){
        return stageTaskService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageTask> select(@PathVariable int id){
        try{
            StageTask stageTask = stageTaskService.select(id);
            return new ResponseEntity<StageTask>(stageTask, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<StageTask>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = stageTaskService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody StageTask stageTask){
        stageTaskService.createStageTask(stageTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody StageTask stageTask, @PathVariable int id){
        try{
            stageTaskService.updateStageTask(stageTask, id);
            return new ResponseEntity<StageTask>(stageTask, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<StageTask>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        stageTaskService.deleteStageTask(id);
    }
}
