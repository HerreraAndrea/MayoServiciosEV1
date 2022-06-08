package com.idat.herreraparedes.service;

import java.util.List;

import com.idat.herreraparedes.model.Curso;


public interface CursoService {
	void guardarCurso(Curso curso);
	void actualizarCurso(Curso curso);
	void eliminarCurso(Integer id);
	List<Curso> listarCurso();
	Curso obtenerCursoPorId(Integer id);
}
