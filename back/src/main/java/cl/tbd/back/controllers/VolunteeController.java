package cl.tbd.back.controllers;

import cl.tbd.back.models.Voluntee;
import cl.tbd.back.services.VolunteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/voluntee")
public class VolunteeController {

    @Autowired
    VolunteeService volunteeService;

    @GetMapping("")
    public List<Voluntee> getAll(){
        return volunteeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntee> select(@PathVariable int id){
        try{
            Voluntee voluntee = volunteeService.select(id);
            return new ResponseEntity<Voluntee>(voluntee, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Voluntee>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = volunteeService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Voluntee voluntee){
        volunteeService.createVoluntee(voluntee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Voluntee voluntee, @PathVariable int id){
        try{
            volunteeService.updateVoluntee(voluntee, id);
            return new ResponseEntity<Voluntee>(voluntee, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Voluntee>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        volunteeService.deleteVoluntee(id);
    }
}
