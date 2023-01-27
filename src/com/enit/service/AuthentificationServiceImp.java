package com.enit.service;

import java.util.List;

import com.enit.entities.Administrateur;
import com.enit.entities.Etudiant;
import com.enit.entities.TypeReclamation;
import com.enit.entities.Utilisateurs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class AuthentificationServiceImp implements AuthentificationServiceLocal {
	@PersistenceContext(unitName="UPRec")
	EntityManager em;


	@Override
	public boolean existeEmail(String email) {
		// TODO Auto-generated method stub
		Utilisateurs Utilisateurs;
		Utilisateurs=em.find(Utilisateurs.class,email);
		if(Utilisateurs!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public void sauvegarderUtilisateur(Utilisateurs utilisateur) {
		// TODO Auto-generated method stub
		em.persist(utilisateur);
		
	}

	@Override
	public List<Etudiant> listerEtudiants() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select e from Etudiant e");
		return req.getResultList();
	}

	@Override
	public Etudiant chercherEtudiant(int id) {
		return em.find(Etudiant.class,id);
	}

	@Override
	public void ajouterEtudiant(Etudiant etud) {
		// TODO Auto-generated method stub
		em.persist(etud);
		
	}

	public void ajouterAdmin(Administrateur ad) {
		// TODO Auto-generated method stub
		em.persist(ad);
		
	}

	@Override
	public void updateActive(String nom, String pren) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("UPDATE Etudiant SET actif = true " +
			      "WHERE nom=:nom ");
			  int updateCount = query.setParameter("nom",nom).executeUpdate();
		
	}

	@Override
	public void updateDActive(String nom, String pren) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("UPDATE Etudiant SET actif = false " +
			      "WHERE nom=:nom ");
			  int updateCount = query.setParameter("nom",nom).executeUpdate();
		
	}

	@Override
	public Utilisateurs authentifieruser(String email, String pwd) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select A from Administrateur A where A.email=:email and A.password=:pwd").setParameter("email",email).setParameter("pwd",pwd);
	
			Utilisateurs ad=(Utilisateurs)req.getSingleResult() ;
	

		return(ad);
	}
	
	

}

	



