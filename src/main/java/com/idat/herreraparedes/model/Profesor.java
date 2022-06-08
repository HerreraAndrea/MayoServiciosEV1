package com.idat.herreraparedes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;
	private String Profesor;
	
	@ManyToMany(mappedBy = "profesor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Curso> curso = new ArrayList<>(); // N:M Profesor - Curso
	
	
	public Integer getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getProfesor() {
		return Profesor;
	}
	public void setProfesor(String profesor) {
		Profesor = profesor;
	}
	
}
