package com.idat.herreraparedes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.herreraparedes.model.MallaCurricular;
import com.idat.herreraparedes.repository.IMallaCurricularRepository;

public class MallaCurricularServiceImpl implements MallaCurricularService{
	
	@Autowired
	private IMallaCurricularRepository repository;

	@Override
	public void guardarMallaCurricular(MallaCurricular mallaCurricular) {
		repository.save(mallaCurricular);
		
	}

	@Override
	public void actualizarMallaCurricular(MallaCurricular mallaCurricular) {
		repository.saveAndFlush(mallaCurricular);
	}

	@Override
	public void eliminarMallaCurricular(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<MallaCurricular> listarMallaCurricular() {
		return repository.findAll();
	}

	@Override
	public MallaCurricular obtenerMallaCurricularPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	

}
