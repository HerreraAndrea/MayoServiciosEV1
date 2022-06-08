package com.idat.herreraparedes.service;

import java.util.List;

import com.idat.herreraparedes.model.Universidad;

public interface UniversidadService {
	void guardarUniversidad(Universidad universidad);
	void actualizarUniversidad(Universidad universidad);
	void eliminarUniversidad(Integer id);
	List<Universidad> listarUniversidad();
	Universidad obtenerUniversidadPorId(Integer id);
}
