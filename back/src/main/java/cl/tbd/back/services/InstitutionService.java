package cl.tbd.back.services;

import cl.tbd.back.models.Institution;
import cl.tbd.back.repositories.InstitutionRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    InstitutionRepositoryImp institutionRepository;

    public List<Institution> getAll(){
        return institutionRepository.findAllInstitution();
    }

    public Institution select(int id){
        return institutionRepository.findInstitution(id);
    }

    public int count(){
        return institutionRepository.countInstitution();
    }

    public Institution createInstitution(Institution institution){
        return institutionRepository.createInstitution(institution);
    }

    public void updateInstitution(Institution institution, int id){
        institutionRepository.updateInstitution(institution, id);
    }

    public void deleteInstitution(int id){
        institutionRepository.deleteInstitution(id);
    }
}
