package com.example.entrevueSpringBoot.domain.movie;

import com.example.entrevueSpringBoot.api.dto.ActorDto;
import com.example.entrevueSpringBoot.api.dto.FilmDto;
import com.example.entrevueSpringBoot.domain.actor.Acteur;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FilmFactory {

	private ActeurFactory actorFactory;

	public FilmFactory(ActeurFactory actorFactory){
		this.actorFactory = actorFactory;
	}

	public Film create(FilmDto filmDto) {
		long id = filmDto.getId();
		String titre = filmDto.getTitre();
		String description = filmDto.getDescription();
		List<ActorDto> actorsDto = filmDto.getActeurs();

		List<Acteur> acteurs =createActorList(actorsDto);


		return new Film(id,titre,description, acteurs);
	}


	public FilmDto create(Film movie){
		FilmDto filmDto = new FilmDto();

		List<Acteur> acteurs = movie.getActeurs();
		List<ActorDto>  actorDtos = createActorDtoList(acteurs);

		filmDto.setId(movie.getId());
		filmDto.setDescription(movie.getDescription());
		filmDto.setTitre(movie.getTitre());
		filmDto.setActeurs(actorDtos);

		return filmDto;
	}


	public List<FilmDto> createMovieDtoList(List<Film> movies){
		return movies.stream().map(this::create).collect(Collectors.toList());
	}

	private List<ActorDto> createActorDtoList(List<Acteur> acteurs) {
		return actorFactory.createActorDtoList(acteurs);
	}

	private List<Acteur> createActorList(List<ActorDto> actorsDto) {
		return actorFactory.createActorList(actorsDto);
	}


}
