package cl.tbd.back.services;

import cl.tbd.back.models.EmergencySkill;
import cl.tbd.back.repositories.EmergencySkillRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencySkillService {

    @Autowired
    EmergencySkillRepositoryImp emergencySkillRepository;

    public List<EmergencySkill> getAll(){
        return emergencySkillRepository.findAllEmergencySkill();
    }

    public EmergencySkill select(int id){
        return emergencySkillRepository.getEmergencySkill(id);
    }

    public int count(){
        return emergencySkillRepository.countEmergencySkill();
    }

    public EmergencySkill createEmergencySkill(EmergencySkill emergencySkill){
        return emergencySkillRepository.createEmergencySkill(emergencySkill);
    }

    public void updateEmergencySkill(EmergencySkill emergencySkill, int id){
        emergencySkillRepository.updateEmergencySkill(emergencySkill,id);
    }

    public void deleteEmergencySkill(int id){
        emergencySkillRepository.deleteEmergencySkill(id);
    }
}
