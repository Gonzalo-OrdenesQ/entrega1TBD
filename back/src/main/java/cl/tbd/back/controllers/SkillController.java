package cl.tbd.back.controllers;

import cl.tbd.back.models.Skill;
import cl.tbd.back.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("")
    public List<Skill> getAll(){
        return skillService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> select(@PathVariable int id){
        try{
            Skill skill = skillService.select(id);
            return new ResponseEntity<Skill>(skill, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Skill>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = skillService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Skill skill){
        skillService.createSkill(skill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Skill skill, @PathVariable int id){
        try{
            skillService.updateSkill(skill, id);
            return new ResponseEntity<Skill>(skill, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Skill>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        skillService.deleteSkill(id);
    }
}
