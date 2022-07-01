package br.com.bootcamp.itau.systemreview.repositories;

import br.com.bootcamp.itau.systemreview.models.Score;
import br.com.bootcamp.itau.systemreview.models.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
