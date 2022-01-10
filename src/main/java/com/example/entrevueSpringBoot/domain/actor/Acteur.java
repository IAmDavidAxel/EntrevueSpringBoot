package com.example.entrevueSpringBoot.domain.actor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Acteur {

	@Id
	@Column
	private  long id;
	@Column
	private  String nom;
	@Column
	private  String prenom;

	public Acteur(long id, String name, String lastName) {
		this.id = id;
		this.nom = name;
		this.prenom = lastName;
	}

	public Acteur() {

	}

	public String getPrenom() {
		return prenom;
	}

	public long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
}
