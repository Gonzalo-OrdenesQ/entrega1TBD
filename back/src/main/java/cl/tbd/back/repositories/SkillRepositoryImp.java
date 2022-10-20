package cl.tbd.back.repositories;

import cl.tbd.back.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class SkillRepositoryImp implements SkillRepository{

    @Autowired
    Sql2o sql2o;

    @Override
    public List<Skill> findAllSkill() {
        String select = "SELECT * FROM skill";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(Skill.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Skill findSkill(int id) {
        String select = "SELECT * FROM skill WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Skill.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countSkill() {
        String count = "SELECT COUNT(*) FROM skill";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Skill createSkill(Skill skill) {
        String insert = "INSERT INTO skill (name, description) " +
                        "VALUES (:name, :description)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert,true)
                    .addParameter("name", skill.getName())
                    .addParameter("description", skill.getDescription())
                    .executeUpdate();
            return skill;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateSkill(Skill skill, int id) {
        String update = "UPDATE skill SET name = :name, description = :description, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("name", skill.getName())
                    .addParameter("description", skill.getDescription())
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteSkill(int id) {
        String delete = "DELETE FROM skill WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
