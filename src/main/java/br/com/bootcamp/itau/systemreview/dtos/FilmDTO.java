package br.com.bootcamp.itau.systemreview.dtos;

import br.com.bootcamp.itau.systemreview.models.Film;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Writer")
    private String writer;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Awards")
    private String awards;

    private Double score;

    private Integer count;

    public FilmDTO(Film film){
        id = film.getId();
        title = film.getTitle();
        plot = film.getPlot();
        runtime = film.getRuntime();
        released = film.getReleased();
        genre = film.getGenre();
        director = film.getDirector();
        writer = film.getWriter();
        actors = film.getActors();
        score = film.getScore();
        count = film.getCount();
    }
}
