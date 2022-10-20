package cl.tbd.back.repositories;

import cl.tbd.back.models.Ranking;

import java.util.List;

public interface RankingRepository {

    public List<Ranking> findAllRanking();
    public Ranking findRanking(int id);
    public int countRanking();
    public Ranking createRanking(Ranking ranking);
    public void updateRanking (Ranking ranking, int id);
    public void deleteRanking (int id);
}
