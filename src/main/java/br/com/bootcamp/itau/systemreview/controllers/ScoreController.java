package br.com.bootcamp.itau.systemreview.controllers;

import br.com.bootcamp.itau.systemreview.dtos.FilmDTO;
import br.com.bootcamp.itau.systemreview.dtos.ScoreDTO;
import br.com.bootcamp.itau.systemreview.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

//	@Autowired
//	private ScoreService service;
	
//	@PutMapping
//	public FilmDTO saveScore(@RequestBody ScoreDTO dto){
//		FilmDTO filmDTO = service.saveScore(dto);
//		return FilmDTO;
//	}
}
