package br.com.bootcamp.itau.systemreview.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "scores")
public class Score {

    @EmbeddedId
    private ScorePK id = new ScorePK();

    private Double value;

    public void setFilm(Film film) {
        id.setFilm(film);
    }

    public void setUser(User user) {
        id.setUser(user);
    }
}
