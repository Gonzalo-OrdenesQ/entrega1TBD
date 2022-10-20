package cl.tbd.back.controllers;

import cl.tbd.back.models.VolunteeSkill;
import cl.tbd.back.services.VolunteeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/voluntee_skill")
public class VolunteeSkillController {

    @Autowired
    VolunteeSkillService volunteeSkillService;

    @GetMapping("")
    public List<VolunteeSkill> getAll(){
        return volunteeSkillService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteeSkill> select(@PathVariable int id){
        try{
            VolunteeSkill volunteeSkill = volunteeSkillService.select(id);
            return new ResponseEntity<VolunteeSkill>(volunteeSkill, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<VolunteeSkill>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = volunteeSkillService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody VolunteeSkill volunteeskill){
        volunteeSkillService.createVolunteeSkill(volunteeskill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody VolunteeSkill volunteeSkill, @PathVariable int id){
        try{
            volunteeSkillService.updateVolunteeSkill(volunteeSkill,id);
            return new ResponseEntity<VolunteeSkill>(volunteeSkill, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<VolunteeSkill>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        volunteeSkillService.deleteVolunteeSkill(id);
    }
}
