package cl.tbd.back.repositories;

import cl.tbd.back.models.Voluntee;

import java.util.List;

public interface VolunteeRepository {

    public List<Voluntee> findAllVoluntee();
    public Voluntee findVoluntee(int id);
    public int countVoluntee();
    public Voluntee createVoluntee(Voluntee voluntee);
    public void updateVoluntee(Voluntee voluntee, int id);
    public void deleteVoluntee(int id);
}
