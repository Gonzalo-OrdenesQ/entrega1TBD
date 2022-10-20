package cl.tbd.back.controllers;

import cl.tbd.back.models.Task;
import cl.tbd.back.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> select(@PathVariable int id){
        try{
            Task task = taskService.select(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = taskService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Task task){
        taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Task task, @PathVariable int id){
        try{
            taskService.updateSkill(task, id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        taskService.deleteSkill(id);
    }
}
