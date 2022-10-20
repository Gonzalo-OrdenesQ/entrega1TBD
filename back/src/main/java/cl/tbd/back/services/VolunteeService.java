package cl.tbd.back.services;

import cl.tbd.back.models.Voluntee;
import cl.tbd.back.repositories.VolunteeRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteeService {

    @Autowired
    VolunteeRepositoryImp volunteeRepository;

    public List<Voluntee> getAll(){
        return volunteeRepository.findAllVoluntee();
    }

    public Voluntee select(int id){
        return volunteeRepository.findVoluntee(id);
    }

    public int count(){
        return volunteeRepository.countVoluntee();
    }

    public Voluntee createVoluntee(Voluntee voluntee){
        return volunteeRepository.createVoluntee(voluntee);
    }

    public void updateVoluntee(Voluntee voluntee, int id){
        volunteeRepository.updateVoluntee(voluntee,id);
    }

    public void deleteVoluntee(int id){
        volunteeRepository.deleteVoluntee(id);
    }
}
