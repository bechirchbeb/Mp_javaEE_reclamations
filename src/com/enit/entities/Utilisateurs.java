package com.enit.entities;

import java.io.Serializable;
import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorType;


@Entity @Table(name="Utilisateurs")
@Inheritance (strategy =InheritanceType.JOINED)
@DiscriminatorColumn (name ="TYPE_Utlisateurs" ,discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="UT")
public abstract class Utilisateurs implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Utilisateurs() {
		super();
	}
	public Utilisateurs(int id, String email, String password, boolean actif) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.actif = actif;
	}
	
	protected int id;
	protected String email;
	protected String password;
	protected boolean actif;
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actif, email, id, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateurs other = (Utilisateurs) obj;
		return actif == other.actif && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(password, other.password);
	}
	@Override
	public String toString() {
		return "Utilisateurs [id=" + id + ", email=" + email + ", password=" + password + ", actif=" + actif + "]";
	}
	
}
