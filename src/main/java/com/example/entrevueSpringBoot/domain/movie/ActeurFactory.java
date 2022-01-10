package com.example.entrevueSpringBoot.domain.movie;

import com.example.entrevueSpringBoot.api.dto.ActorDto;
import com.example.entrevueSpringBoot.domain.actor.Acteur;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActeurFactory {

	public Acteur create (ActorDto actorDto){

		long id = actorDto.getId();
		String name = actorDto.getName();
		String lastName = actorDto.getLastName();

		return new Acteur(id,name,lastName);
	}

	public ActorDto create (Acteur acteur){
		ActorDto actorDto = new ActorDto();

		actorDto.setId(acteur.getId());
		actorDto.setName(acteur.getNom());
		actorDto.setLastName(acteur.getPrenom());

		return actorDto;
	}


	public List<Acteur> createActorList(List<ActorDto> actorDtos) {
		return actorDtos.stream().map(this::create).collect(Collectors.toList());
	}

	public List<ActorDto> createActorDtoList(List<Acteur> acteurs){
		return acteurs.stream().map(this::create).collect(Collectors.toList());
	}


}
