package cl.tbd.back.repositories;

import cl.tbd.back.models.Emergency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

import java.util.List;

@Repository
public class EmergencyRepositoryImp implements EmergencyRepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<Emergency> findAllEmergency() {
        String select = "SELECT * FROM emergency ORDER BY id ASC";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(Emergency.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Emergency getEmergency(int id) {
        String select = "SELECT * FROM emergency WHERE id = :id ORDER";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select, true)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Emergency.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countEmergency() {
        String count = "SELECT COUNT(*) FROM emergency";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Emergency createEmergency(Emergency emergency) {
        String insert = "INSERT INTO emergency (name, description, addr)" +
                "VALUES(:name, :description, :addr)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert,true)
                    .addParameter("name", emergency.getName())
                    .addParameter("description", emergency.getDescription())
                    .addParameter("addr", emergency.getAddr())
                    .executeUpdate();
            return emergency;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEmergency(Emergency emergency, int id) {
        String update = "Update Emergency Set name = :name, description = :description, addr = :addr, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("name",emergency.getName())
                    .addParameter("description",emergency.getDescription())
                    .addParameter("addr", emergency.getAddr())
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteEmergency(int id) {
        String delete = "DELETE FROM emergency WHERE emergency.id = :id";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(delete)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
