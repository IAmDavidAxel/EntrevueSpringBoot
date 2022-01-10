package com.example.entrevueSpringBoot.application.service;

import com.example.entrevueSpringBoot.api.dto.FilmDto;
import com.example.entrevueSpringBoot.domain.movie.Film;
import com.example.entrevueSpringBoot.domain.movie.FilmFactory;
import com.example.entrevueSpringBoot.domain.movie.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

	private MovieRepository movieRepository;
	private FilmFactory filmFactory;

	public MovieService(MovieRepository movieRepository, FilmFactory filmFactory){
		this.movieRepository = movieRepository;
		this.filmFactory = filmFactory;
	}


	public void create(FilmDto filmDto) {
		Film movie = createMovieFromFactory(filmDto);
		save(movie);
	}

	private void save(Film movie) {
		movieRepository.save(movie);
	}

	private Film createMovieFromFactory(FilmDto filmDto) {
		return filmFactory.create(filmDto);
	}

	public FilmDto getById(long id) {
		Film film = findMovieById(id);

		return filmFactory.create(film);
	}

	private Film findMovieById(long id) {
		return movieRepository.findById(1).get();
	}
}
