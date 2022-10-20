package cl.tbd.back.services;

import cl.tbd.back.models.Skill;
import cl.tbd.back.repositories.SkillRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepositoryImp skillRepository;

    public List<Skill> getAll(){
        return skillRepository.findAllSkill();
    }

    public Skill select(int id){
        return skillRepository.findSkill(id);
    }

    public int count(){
        return skillRepository.countSkill();
    }

    public Skill createSkill(Skill skill){
        return skillRepository.createSkill(skill);
    }

    public void updateSkill(Skill skill, int id){
        skillRepository.updateSkill(skill, id);
    }

    public void deleteSkill(int id){
        skillRepository.deleteSkill(id);
    }
}
