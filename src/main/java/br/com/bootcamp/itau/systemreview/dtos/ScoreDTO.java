package br.com.bootcamp.itau.systemreview.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ScoreDTO {

	private Long filmId;
	private String email;
	private Double score;

}