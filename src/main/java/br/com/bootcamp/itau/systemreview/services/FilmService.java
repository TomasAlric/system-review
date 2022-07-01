package br.com.bootcamp.itau.systemreview.services;

import br.com.bootcamp.itau.systemreview.dtos.FilmDTO;
import br.com.bootcamp.itau.systemreview.mappers.MapperFilm;
import br.com.bootcamp.itau.systemreview.models.Film;
import br.com.bootcamp.itau.systemreview.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository repository;
    private final OmbdApiService ombdApiService;
    private final MapperFilm mapperFilm;

    @Transactional
    public FilmDTO findByTitle(String title){
        MultiValueMap<String, String> values = new LinkedMultiValueMap<>();
        values.add("t", title);

        FilmDTO filmDto = ombdApiService.findFilm(values);

        Film film = mapperFilm.toEntity(filmDto);

        repository.save(film);

        return filmDto;
    }
}
