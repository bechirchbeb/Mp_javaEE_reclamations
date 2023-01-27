package com.enit.service;

import java.util.List;

import com.enit.entities.Administrateur;
import com.enit.entities.Etudiant;
import com.enit.entities.Reclamation;
import com.enit.entities.TypeReclamation;
import com.enit.entities.Utilisateurs;

import jakarta.ejb.Local;

@Local
public interface AuthentificationServiceLocal {
	public Utilisateurs authentifieruser(String email,String pwd);
	boolean existeEmail(String email);
	void sauvegarderUtilisateur(Utilisateurs utilisateur);
	List<Etudiant> listerEtudiants();
	public Etudiant chercherEtudiant(int id);
	public void ajouterEtudiant(Etudiant etud);
	public void ajouterAdmin(Administrateur ad);
    public void updateActive(String nom,String pren) ;
    public void updateDActive(String nom,String pren) ;
}
