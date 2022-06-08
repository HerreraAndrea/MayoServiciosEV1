package com.idat.herreraparedes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MallaCurricular")
public class MallaCurricular {
	
	@Id
	@GeneratedValue
	private Integer idMalla;
	private Integer anio;
	
	//Universidad - Malla 1:1
	@OneToOne(mappedBy = "universidad", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Universidad universidad;
	
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
}
