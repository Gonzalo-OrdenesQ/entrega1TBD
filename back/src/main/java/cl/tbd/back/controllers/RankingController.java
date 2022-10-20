package cl.tbd.back.controllers;

import cl.tbd.back.models.Ranking;
import cl.tbd.back.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    RankingService rankingService;

    @GetMapping("")
    public List<Ranking> getAll(){
        return rankingService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ranking> select(@PathVariable int id){
        try{
            Ranking ranking = rankingService.select(id);
            return new ResponseEntity<Ranking>(ranking, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Ranking>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count(){
        try{
            Integer count = rankingService.count();
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Ranking ranking){
        rankingService.createRanking(ranking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Ranking ranking, @PathVariable int id){
        try{
            rankingService.updateRanking(ranking, id);
            return new ResponseEntity<Ranking>(ranking, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Ranking>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = {RequestMethod.DELETE})
    public void delete(@PathVariable int id){
        rankingService.deleteRanking(id);
    }
}
