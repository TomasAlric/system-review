package br.com.bootcamp.itau.systemreview.repositories;

import br.com.bootcamp.itau.systemreview.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

}
