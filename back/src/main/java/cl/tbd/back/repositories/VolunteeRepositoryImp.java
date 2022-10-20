package cl.tbd.back.repositories;

import cl.tbd.back.models.Voluntee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolunteeRepositoryImp implements VolunteeRepository {

    @Autowired
    Sql2o sql2o;


    @Override
    public List<Voluntee> findAllVoluntee() {
        String select = "SELECT * FROM voluntee";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(Voluntee.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Voluntee findVoluntee(int id) {
        String select = "SELECT * FROM voluntee WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntee.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countVoluntee() {
        String count = "SELECT COUNT(*) FROM voluntee";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Voluntee createVoluntee(Voluntee voluntee) {
        String insert = "INSERT INTO voluntee (name, email, pass) " +
                        "VALUES (:name, :email, :pass)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert,true)
                    .addParameter("name",voluntee.getName())
                    .addParameter("email", voluntee.getEmail())
                    .addParameter("pass", voluntee.getPass())
                    .executeUpdate();
            return voluntee;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateVoluntee(Voluntee voluntee, int id) {
        String update = "UPDATE voluntee SET name = :name, email = :email, pass = :pass, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("name", voluntee.getName())
                    .addParameter("email", voluntee.getEmail())
                    .addParameter("pass", voluntee.getPass())
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteVoluntee(int id) {
        String delete = "DELETE FROM voluntee WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
