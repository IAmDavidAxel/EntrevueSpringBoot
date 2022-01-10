package com.example.entrevueSpringBoot.api.resources.movie;

import com.example.entrevueSpringBoot.api.dto.FilmDto;
import com.example.entrevueSpringBoot.application.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MovieResource {

	private MovieService movieService;

	public MovieResource(MovieService movieService){
		this.movieService = movieService;
	}


	@PostMapping(value = "/film/")
	public ResponseEntity<FilmDto> createMovie(@RequestBody FilmDto filmDto){

		movieService.create(filmDto);

		return new ResponseEntity<>(filmDto, HttpStatus.CREATED);

	}

	@GetMapping("film/{id}")
	public ResponseEntity<FilmDto> getMovie(@PathVariable long id){

		FilmDto filmDto = movieService.getById(id);


		return new ResponseEntity<>(filmDto,HttpStatus.OK);
	}
}
