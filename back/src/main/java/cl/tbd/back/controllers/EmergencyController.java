package cl.tbd.back.controllers;

import cl.tbd.back.models.Emergency;
import cl.tbd.back.services.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/emergency")
public class EmergencyController {

    @Autowired
    EmergencyService emergencyService;

    @GetMapping("")
    public List<Emergency> getAll(){
        return emergencyService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emergency> select(@PathVariable int id){
        try{
            Emergency emergency = emergencyService.select(id);
            return new ResponseEntity<Emergency>(emergency, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Emergency>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = emergencyService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Emergency emergency){
        emergencyService.createEmergency(emergency);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Emergency emergency, @PathVariable int id){
        try{
            emergencyService.updateEmergency(emergency, id);
            return new ResponseEntity<Emergency>(emergency, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Emergency>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        emergencyService.deleteEmercency(id);
    }
}
