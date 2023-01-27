package com.enit.entities;

import java.io.Serializable;
import java.util.Objects;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity 
public class Reclamation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Reclamation() {
		super();
	}
	public Reclamation(int id_reclamation, String titre, String description) {
		super();
		this.id_reclamation = id_reclamation;
		this.titre = titre;
		this.description = description;
	}
	
	private int id_reclamation;
	private String titre;
	private String description;
	private Etudiant etudiant;
	private TypeReclamation typereclamation;
	@Id
	
	public int getId_reclamation() {
		return id_reclamation;
	}
	public void setId_reclamation(int id_reclamation) {
		this.id_reclamation = id_reclamation;
	}
	@Column
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Reclamation [id_reclamation=" + id_reclamation + ", titre=" + titre + ", description=" + description
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id_reclamation, titre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reclamation other = (Reclamation) obj;
		return Objects.equals(description, other.description) && id_reclamation == other.id_reclamation
				&& Objects.equals(titre, other.titre);
	}
	@ManyToOne
	@JoinColumn (name="EtudFOREIGNKEY")
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	@ManyToOne
	@JoinColumn(name="TRecFOREIGNKEY")
	
	public TypeReclamation getTypereclamation() {
		return typereclamation;
	}
	public void setTypereclamation(TypeReclamation typereclamation) {
		this.typereclamation = typereclamation;
	}
}
