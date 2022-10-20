package cl.tbd.back.repositories;

import cl.tbd.back.models.Institution;

import java.util.List;

public interface InstitutionRepository {

    public List<Institution> findAllInstitution();
    public Institution findInstitution(int id);
    public int countInstitution();
    public Institution createInstitution(Institution institution);
    public void updateInstitution(Institution institution, int id);
    public void deleteInstitution(int id);
}
