package com.idat.herreraparedes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.herreraparedes.model.Profesor;
import com.idat.herreraparedes.repository.IProfesorRepository;

public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	private IProfesorRepository repository;

	@Override
	public void guardarProfesor(Profesor profesor) {
		repository.save(profesor);
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		repository.saveAndFlush(profesor);
		
	}

	@Override
	public void eliminarProfesor(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Profesor> listarProfesor() {
		return repository.findAll();
	}

	@Override
	public Profesor obtenerProfesorPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	

}
