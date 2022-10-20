package cl.tbd.back.controllers;

import cl.tbd.back.models.Institution;
import cl.tbd.back.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    InstitutionService institutionService;

    @GetMapping("")
    public List<Institution> getAll(){
        return institutionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institution> select(@PathVariable int id){
        try{
            Institution institution = institutionService.select(id);
            return new ResponseEntity<Institution>(institution, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Institution>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = institutionService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Institution institution){
        institutionService.createInstitution(institution);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Institution institution, @PathVariable int id){
        try{
            institutionService.updateInstitution(institution, id);
            return new ResponseEntity<Institution>(institution, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Institution>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        institutionService.deleteInstitution(id);
    }
}
