package com.example.entrevueSpringBoot.domain.movie;

import com.example.entrevueSpringBoot.domain.actor.Acteur;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
public class Film {

	@Id
	@Column
	private  long id;
	@Column
	private  String titre;
	@Column
	private  String description;
	@OneToMany
	private  List<Acteur> acteurs;

	public Film(long id, String titre, String description, List<Acteur> acteurs) {

		this.id = id;
		this.titre = titre;
		this.description = description;
		this.acteurs = acteurs;
	}

	public Film() {

	}

	public long getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public String getDescription() {
		return description;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}
}
