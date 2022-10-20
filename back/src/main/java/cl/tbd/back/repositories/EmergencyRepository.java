package cl.tbd.back.repositories;

import cl.tbd.back.models.Emergency;

import java.util.List;

public interface EmergencyRepository {
    public List<Emergency> findAllEmergency();
    public Emergency getEmergency(int id);
    public int countEmergency();
    public Emergency createEmergency(Emergency emergency);
    public void updateEmergency(Emergency emergency, int id);
    public void deleteEmergency(int id);
}
