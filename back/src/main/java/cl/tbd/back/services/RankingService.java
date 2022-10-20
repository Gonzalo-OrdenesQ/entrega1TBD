package cl.tbd.back.services;

import cl.tbd.back.models.Ranking;
import cl.tbd.back.repositories.RankingRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    RankingRepositoryImp rankingRepository;

    public List<Ranking> getAll(){
        return rankingRepository.findAllRanking();
    }

    public Ranking select(int id){
        return rankingRepository.findRanking(id);
    }

    public int count(){
        return rankingRepository.countRanking();
    }

    public Ranking createRanking(Ranking ranking){
        return rankingRepository.createRanking(ranking);
    }

    public void updateRanking(Ranking ranking, int id){
        rankingRepository.updateRanking(ranking, id);
    }

    public void deleteRanking(int id){
        rankingRepository.deleteRanking(id);
    }
}
