package com.example.entrevueSpringBoot.api.dto;

import java.util.List;

public class FilmDto {
	private long id;
	private String titre;
	private String description;
	private List<ActorDto> acteurs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ActorDto> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<ActorDto> acteurs) {
		this.acteurs = acteurs;
	}
}
