package cl.tbd.back.services;

import cl.tbd.back.models.Emergency;
import cl.tbd.back.repositories.EmergencyRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyService {

    @Autowired
    EmergencyRepositoryImp emergencyRepository;

    public List<Emergency> getAll(){
        return emergencyRepository.findAllEmergency();
    }

    public Emergency select(int id){
        return emergencyRepository.getEmergency(id);
    }

    public int count(){
        return emergencyRepository.countEmergency();
    }

    public Emergency createEmergency(Emergency emergency){
        return emergencyRepository.createEmergency(emergency);
    }

    public void updateEmergency(Emergency emergency, int id){
        emergencyRepository.updateEmergency(emergency,id);
    }

    public void deleteEmercency(int id){
        emergencyRepository.deleteEmergency(id);
    }
}
