package com.enit.entities;
import java.util.Collection;



import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;



@Entity 
@DiscriminatorValue(value="ET")
public class Etudiant extends Utilisateurs {
	
	private static final long serialVersionUID = 1L;
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant(int id, String email, String password, boolean actif,String nom,String prenom) {
		super(id, email, password, actif);
		// TODO Auto-generated constructor stub
		this.nom=nom;
		this.prenom=prenom;
	}
	private String nom ; 
	 private String prenom ;
	  private Collection<Reclamation> reclamations;
	 @Column
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Column
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + "]";
	}
	@OneToMany(mappedBy="etudiant")
	public Collection<Reclamation> getReclamation() {
		return reclamations;
	}
	public void setReclamation(Collection<Reclamation> reclamation) {
		reclamations = reclamation;
	} 
	   
}
