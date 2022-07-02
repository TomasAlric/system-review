package br.com.bootcamp.itau.systemreview.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "films")
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Plot")
    @Column(columnDefinition = "TEXT")
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

    @OneToMany(mappedBy = "id.film")
    private Set<Score> scores = new HashSet<>();
}
