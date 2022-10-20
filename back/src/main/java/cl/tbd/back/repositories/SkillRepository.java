package cl.tbd.back.repositories;

import cl.tbd.back.models.Skill;

import java.util.List;

public interface SkillRepository {

    public List<Skill> findAllSkill();
    public Skill findSkill(int id);
    public int countSkill();
    public Skill createSkill(Skill skill);
    public void updateSkill(Skill skill, int id);
    public void deleteSkill(int id);
}
