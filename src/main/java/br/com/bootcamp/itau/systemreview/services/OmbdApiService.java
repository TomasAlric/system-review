package br.com.bootcamp.itau.systemreview.services;

import br.com.bootcamp.itau.systemreview.dtos.FilmDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OmbdApiService {

    @Value("omdapi.apikey")
    private String apikey;

    public FilmDTO findFilm(MultiValueMap multipartValue){
        RestTemplate template = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("www.omdbapi.com")
                .queryParams(multipartValue)
                .queryParam("apikey", "9c1a96bd")
                .build();

        ResponseEntity<FilmDTO> entity = template.getForEntity(uri.toUriString(), FilmDTO.class);

        return entity.getBody();
    }
}
