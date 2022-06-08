package com.idat.herreraparedes.service;

import java.util.List;

import com.idat.herreraparedes.model.Profesor;

public interface ProfesorService {
	void guardarProfesor(Profesor profesor);
	void actualizarProfesor(Profesor profesor);
	void eliminarProfesor(Integer id);
	List<Profesor> listarProfesor();
	Profesor obtenerProfesorPorId(Integer id);
}
