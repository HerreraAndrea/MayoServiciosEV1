package com.idat.herreraparedes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.herreraparedes.model.Universidad;
import com.idat.herreraparedes.repository.IUniversidadRepository;

public class UniversidadServiceImpl implements UniversidadService {

	@Autowired
	private IUniversidadRepository repository;
	
	@Override
	public void guardarUniversidad(Universidad universidad) {
		repository.save(universidad);
		
	}

	@Override
	public void actualizarUniversidad(Universidad universidad) {
		repository.saveAndFlush(universidad);
		
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Universidad> listarUniversidad() {
		return repository.findAll();
	}

	@Override
	public Universidad obtenerUniversidadPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
