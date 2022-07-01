package br.com.bootcamp.itau.systemreview.controllers;

import br.com.bootcamp.itau.systemreview.dtos.FilmDTO;
import br.com.bootcamp.itau.systemreview.services.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/film")
public class FilmController {

    @Autowired
    private FilmService service;

    @GetMapping("/{title}")
    public ResponseEntity<FilmDTO> findByTitle(@PathVariable String title) {
        log.info("Finding films by title");
        return ResponseEntity.ok(service.findByTitle(title));
    }
}
