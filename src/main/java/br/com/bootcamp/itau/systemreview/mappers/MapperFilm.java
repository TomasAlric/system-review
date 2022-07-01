package br.com.bootcamp.itau.systemreview.mappers;

import br.com.bootcamp.itau.systemreview.dtos.FilmDTO;
import br.com.bootcamp.itau.systemreview.models.Film;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperFilm {
    FilmDTO toDto(Film film);

    Film toEntity(FilmDTO filmDTO);
}
