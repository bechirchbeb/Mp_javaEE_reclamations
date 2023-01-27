package com.enit.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity 
@DiscriminatorValue(value="Ad")
public class Administrateur extends Utilisateurs{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(int id, String email, String password, boolean actif) {
		super(id, email, password, actif);
		// TODO Auto-generated constructor stub
	}
  
}
