package cl.tbd.back.repositories;

import cl.tbd.back.models.EmergencySkill;

import java.util.List;

public interface EmergencySkillRepository {
    public List<EmergencySkill> findAllEmergencySkill();
    public EmergencySkill getEmergencySkill(int id);
    public int countEmergencySkill();
    public EmergencySkill createEmergencySkill(EmergencySkill emergencySkill);
    public void updateEmergencySkill(EmergencySkill emergencySkill, int id);
    public void deleteEmergencySkill(int id);
}
