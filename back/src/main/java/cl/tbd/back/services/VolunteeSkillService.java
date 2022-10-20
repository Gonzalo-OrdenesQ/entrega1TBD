package cl.tbd.back.services;

import cl.tbd.back.models.VolunteeSkill;
import cl.tbd.back.repositories.VolunteeSkillRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteeSkillService {

    @Autowired
    VolunteeSkillRepositoryImp volunteeSkillRepository;

    public List<VolunteeSkill> getAll(){
        return volunteeSkillRepository.findAllVolunteeSkill();
    }

    public VolunteeSkill select(int id){
        return volunteeSkillRepository.findVolunteeSkill(id);
    }

    public int count(){
        return volunteeSkillRepository.countVolunteeSkill();
    }

    public VolunteeSkill createVolunteeSkill(VolunteeSkill volunteeSkill){
        return volunteeSkillRepository.createVolunteeSkill(volunteeSkill);
    }

    public void updateVolunteeSkill(VolunteeSkill volunteeSkill, int id){
        volunteeSkillRepository.updateVolunteeSkill(volunteeSkill, id);
    }

    public void deleteVolunteeSkill(int id){
        volunteeSkillRepository.deleteVolunteeSkill(id);
    }
}
