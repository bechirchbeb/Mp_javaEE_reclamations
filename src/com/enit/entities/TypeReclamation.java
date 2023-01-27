package com.enit.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
public class TypeReclamation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TypeReclamation() {
		super();
	}
	public TypeReclamation(int id_type, String type) {
		super();
		this.id_type = id_type;
		this.type = type;
	}
	
	private int id_type;
	private String type;
	private Collection<Reclamation> Mesreclamations;
	@Id
	
	public int getId_type() {
		return id_type;
	}
	public void setId_type(int id_type) {
		this.id_type = id_type;
	}
	@Column
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TypeReclamation [id_type=" + id_type + ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_type, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeReclamation other = (TypeReclamation) obj;
		return id_type == other.id_type && Objects.equals(type, other.type);
	}
	@OneToMany(mappedBy="typereclamation")
	public Collection<Reclamation> getMesreclamations() {
		return this.Mesreclamations;
	}
	public void setMesreclamations(Collection<Reclamation> mesreclamations) {
		this.Mesreclamations =mesreclamations;
	}
	

}
