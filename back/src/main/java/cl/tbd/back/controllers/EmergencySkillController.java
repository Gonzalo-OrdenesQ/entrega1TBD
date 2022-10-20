package cl.tbd.back.controllers;

import cl.tbd.back.models.EmergencySkill;
import cl.tbd.back.services.EmergencySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/emergency_skill")
public class EmergencySkillController {

    @Autowired
    EmergencySkillService emergencySkillService;

    @GetMapping("")
    public List<EmergencySkill> getAll(){
        return emergencySkillService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencySkill> select(@PathVariable int id){
        try{
            EmergencySkill emergencySkill = emergencySkillService.select(id);
            return new ResponseEntity<EmergencySkill>(emergencySkill,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<EmergencySkill>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = emergencySkillService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody EmergencySkill emergencySkill){
        emergencySkillService.createEmergencySkill(emergencySkill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencySkill> update(@RequestBody EmergencySkill emergencySkill, @PathVariable int id){
        try{
            emergencySkillService.updateEmergencySkill(emergencySkill,id);
            return new ResponseEntity<EmergencySkill>(emergencySkill,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<EmergencySkill>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = ("/{id}"), produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        emergencySkillService.deleteEmergencySkill(id);
    }
}
