package cl.tbd.back.repositories;

import cl.tbd.back.models.VolunteeSkill;

import java.util.List;

public interface VolunteeSkillRepository {

    public List<VolunteeSkill> findAllVolunteeSkill();
    public VolunteeSkill findVolunteeSkill(int id);
    public int countVolunteeSkill();
    public VolunteeSkill createVolunteeSkill(VolunteeSkill volunteeSkill);
    public void updateVolunteeSkill(VolunteeSkill volunteeSkill, int id);
    public void deleteVolunteeSkill(int id);
}
