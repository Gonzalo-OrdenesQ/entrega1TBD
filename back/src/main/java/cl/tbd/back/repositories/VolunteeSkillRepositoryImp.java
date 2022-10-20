package cl.tbd.back.repositories;

import cl.tbd.back.models.VolunteeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolunteeSkillRepositoryImp implements VolunteeSkillRepository{

    @Autowired
    Sql2o sql2o;


    @Override
    public List<VolunteeSkill> findAllVolunteeSkill() {
        String select = "SELECT * FROM vol_skill";
        try(Connection conn = sql2o.open()){
            List<VolunteeSkill> list= conn.createQuery(select)
                    .executeAndFetch(VolunteeSkill.class);
            System.out.println("VolunteeSkill");
            return list;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public VolunteeSkill findVolunteeSkill(int id) {
        String select = "SELECT * FROM vol_skill WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id",id)
                    .executeAndFetchFirst(VolunteeSkill.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countVolunteeSkill() {
        String count = "SELECT COUNT(*) FROM vol_skill";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public VolunteeSkill createVolunteeSkill(VolunteeSkill volunteeSkill) {
        String insert = "INSERT INTO vol_skill (id_voluntee, id_skill) " +
                        "VALUES (:id_voluntee, :id_skill)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert, true)
                    .addParameter("id_voluntee", volunteeSkill.getId_voluntee())
                    .addParameter("id_skill", volunteeSkill.getId_skill())
                    .executeUpdate();
            return volunteeSkill;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateVolunteeSkill(VolunteeSkill volunteeSkill, int id) {
        String update = "UPDATE vol_skill SET id_voluntee = :id_voluntee, id_skill = :id_skill, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("id_voluntee", volunteeSkill.getId_voluntee())
                    .addParameter("id_skill", volunteeSkill.getId_skill())
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteVolunteeSkill(int id) {
        String delete = "DELETE FROM vol_skill WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id",id);
        }
    }
}
