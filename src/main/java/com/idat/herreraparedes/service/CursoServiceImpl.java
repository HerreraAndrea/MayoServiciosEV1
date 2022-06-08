package com.idat.herreraparedes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.herreraparedes.model.Curso;
import com.idat.herreraparedes.repository.ICursoRepository;

public class CursoServiceImpl implements CursoService{

	@Autowired
	private ICursoRepository repository;
	
	@Override
	public void guardarCurso(Curso curso) {
		repository.save(curso);
		
	}

	@Override
	public void actualizarCurso(Curso curso) {
		repository.saveAndFlush(curso);
		
	}

	@Override
	public void eliminarCurso(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Curso> listarCurso() {
		return repository.findAll();
	}

	@Override
	public Curso obtenerCursoPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
