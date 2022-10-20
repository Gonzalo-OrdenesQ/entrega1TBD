package cl.tbd.back.repositories;

import cl.tbd.back.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{

    @Autowired
    Sql2o sql2o;


    @Override
    public List<Ranking> findAllRanking() {
        String select = "SELECT * FROM  ranking";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .executeAndFetch(Ranking.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Ranking findRanking(int id) {
        String select = "SELECT * FROM ranking WERE id = :id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(select)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranking.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countRanking() {
        String count = "SELECT COUNT(*) FROM ranking";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(count)
                    .executeScalar(Integer.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Ranking createRanking(Ranking ranking) {
        String insert = "INSERT INTO ranking (id_voluntee, id_task, score) " +
                        "VALUES (:id_voluntee, :id_task, :score)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(insert, true)
                    .addParameter("id_voluntee", ranking.getId_voluntee())
                    .addParameter("id_task", ranking.getId_task())
                    .addParameter("score", ranking.getScore())
                    .executeUpdate();
            return ranking;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateRanking(Ranking ranking, int id) {
        String update = "UPDATE ranking SET id_voluntee = :id_voluntee, id_task = :id_task, score = :score, id = :id WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(update)
                    .addParameter("id_voluntee", ranking.getId_voluntee())
                    .addParameter("id_task", ranking.getId_task())
                    .addParameter("score", ranking.getScore())
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteRanking(int id) {
        String delete = "DELETE FROM ranking WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(delete)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
