package com.idat.herreraparedes.service;

import java.util.List;

import com.idat.herreraparedes.model.MallaCurricular;


public interface MallaCurricularService {
	void guardarMallaCurricular(MallaCurricular mallaCurricular);
	void actualizarMallaCurricular(MallaCurricular mallaCurricular);
	void eliminarMallaCurricular(Integer id);
	List<MallaCurricular> listarMallaCurricular();
	MallaCurricular obtenerMallaCurricularPorId(Integer id);

}
