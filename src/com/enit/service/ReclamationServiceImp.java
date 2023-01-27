package com.enit.service;

import java.util.List;


import com.enit.entities.Etudiant;
import com.enit.entities.Reclamation;
import com.enit.entities.TypeReclamation;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ReclamationServiceImp implements ReclamationServiceLocal{
	@PersistenceContext(unitName="UPRec")
	EntityManager em;
	@Override
	public void ajouterReclamation(Reclamation reclamation)
	{
		em.persist(reclamation);
	}
	@Override
	public void ajouterTypeReclamation(TypeReclamation typeReclamation) {
		// TODO Auto-generated method stub
		em.persist(typeReclamation);
	}
	@Override
	public List<Reclamation> listerReclamations() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select R from Reclamation R");
		return req.getResultList();	
	}
	@Override
	public List<TypeReclamation> listerTypeReclamations() {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select T from TypeReclamation T");
		return req.getResultList();
	}
	@Override
	public boolean existeTypeReclalamtion(String type) {
		// TODO Auto-generated method stub
		TypeReclamation TypeReclamation;
		TypeReclamation=em.find(TypeReclamation.class,type );
		if(TypeReclamation!=null)
		{
			return true;
		}
		return false;
		
	}
	@Override
	public TypeReclamation chercherTypeReclamationParType(String type) {
		// TODO Auto-generated method stub
		 return em.find(TypeReclamation.class,type);
	}
	@Override
	public List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		Query req=em.createQuery("select T from TypeReclamation where T.etudiant=etudiant");
		return req.getResultList();
	}
	@Override
	public Reclamation chercherReclamation(Integer id_reclamation) {
		// TODO Auto-generated method stub
		 return em.find(Reclamation.class, id_reclamation);
	}
	@Override
	public TypeReclamation chercherTypeReclamationParid(int id_type) {
		// TODO Auto-generated method stub
		return em.find(TypeReclamation.class,id_type);
	}
	
}
