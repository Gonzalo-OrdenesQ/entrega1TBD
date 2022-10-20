package cl.tbd.back.repositories;

import cl.tbd.back.models.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitutionRepositoryImp implements InstitutionRepository{

    @Autowired
    Sql2o sql2o;

    @Override
    public List<Institution> findAllInstitution() {
        String select = "SELECT * FROM institution";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(Institution.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Institution findInstitution(int id) {
        String select = "SELECT FROM institution WHERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Institution.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countInstitution() {
        String count = "SELECT COUNT(*) FROM institution";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Institution createInstitution(Institution institution) {
        String insert = "INSERT INTO institution (name, addr) " +
                        "VALUES (:name, :addr)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert,true)
                    .addParameter("name", institution.getName())
                    .addParameter("addr", institution.getAddr())
                    .executeUpdate();
            return institution;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateInstitution(Institution institution, int id) {
        String update = "UPDATE institution SET name = :name, addr = :addr, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("name", institution.getName())
                    .addParameter("addr", institution.getAddr())
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteInstitution(int id) {
        String delete = "DELETE FROM institution WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id",id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
