package cl.tbd.back.repositories;

import cl.tbd.back.models.EmergencySkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergencySkillRepositoryImp implements EmergencySkillRepository{

    @Autowired
    Sql2o sql2o;

    @Override
    public List<EmergencySkill> findAllEmergencySkill() {
        String select = "SELECT * FROM eme_skill";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(EmergencySkill.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public EmergencySkill getEmergencySkill(int id) {
        String select = "SELECT * FROM eme_skill WHERE emergency.id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmergencySkill.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countEmergencySkill() {
        String count = "SELECT COUNT(*) FROM eme_skill";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public EmergencySkill createEmergencySkill(EmergencySkill emergencySkill) {
        String insert = "INSERT INTO eme_skill (id_emergency, id_skill) "+
                        "VALUES (:id_emergency, :id_skill)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert,true)
                    .addParameter("id_emergency", emergencySkill.getId_emergency())
                    .addParameter("id_skill", emergencySkill.getId_skill())
                    .executeUpdate();
            return emergencySkill;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEmergencySkill(EmergencySkill emergencySkill, int id) {
        String update = "UPDATE eme_skill SET id_emergency = :id_emergency, id_skill = :id_skill, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("id_emergency", emergencySkill.getId_emergency())
                    .addParameter("id_skill", emergencySkill.getId_skill())
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteEmergencySkill(int id) {
        String delete = "DELETE FROM eme_skill WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
