package cl.tbd.back.controllers;

import cl.tbd.back.models.TaskSkill;
import cl.tbd.back.services.TaskSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/task_skill")
public class TaskSkillController {

    @Autowired
    TaskSkillService taskSkillService;

    @GetMapping("")
    public List<TaskSkill> getAll(){
        return taskSkillService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskSkill> select(@PathVariable int id){
        try{
            TaskSkill taskSkill = taskSkillService.select(id);
            return new ResponseEntity<TaskSkill>(taskSkill, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<TaskSkill>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = taskSkillService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody TaskSkill taskSkill){
        taskSkillService.createTaskSkill(taskSkill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TaskSkill taskSkill, @PathVariable int id){
        try{
            taskSkillService.updateTaskSkill(taskSkill, id);
            return new ResponseEntity<TaskSkill>(taskSkill, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<TaskSkill>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        taskSkillService.deleteTaskSkill(id);
    }
}
