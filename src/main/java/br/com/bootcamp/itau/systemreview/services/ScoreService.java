package br.com.bootcamp.itau.systemreview.services;

import br.com.bootcamp.itau.systemreview.dtos.FilmDTO;
import br.com.bootcamp.itau.systemreview.dtos.ScoreDTO;
import br.com.bootcamp.itau.systemreview.models.Film;
import br.com.bootcamp.itau.systemreview.models.Score;
import br.com.bootcamp.itau.systemreview.models.User;
import br.com.bootcamp.itau.systemreview.repositories.FilmRepository;
import br.com.bootcamp.itau.systemreview.repositories.ScoreRepository;
import br.com.bootcamp.itau.systemreview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public FilmDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Film film = filmRepository.findById(dto.getFilmId()).get();

		Score score = new Score();
		score.setFilm(film);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : film.getScores()) {
			sum = sum + s.getValue();
		}

		double avg = sum / film.getScores().size();

		film.setScore(avg);
		film.setCount(film.getScores().size());

		film = filmRepository.save(film);

		return new FilmDTO(film);
	}
}