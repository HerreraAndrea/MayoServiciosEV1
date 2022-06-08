package com.idat.herreraparedes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.herreraparedes.model.Curso;
import com.idat.herreraparedes.service.CursoServiceImpl;


@Controller
@RequestMapping("/curso/v1")
public class CursoController {
	@Autowired
	private CursoServiceImpl service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Curso>> listarCurso() {
		return new ResponseEntity<List<Curso>>(service.listarCurso(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarCurso(@RequestBody Curso curso) {
		service.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCurso(@PathVariable Integer id) {
		
		Curso c = service.obtenerCursoPorId(id);
		
		if(c != null) {
			service.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
	}
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarCurso(@RequestBody Curso curso) {
		
		Curso c= service.obtenerCursoPorId(curso.getIdCurso());
		
		if(c != null) {
			service.actualizarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Integer id) {
		Curso c = service.obtenerCursoPorId(id);
		
		if(c != null) {
			return new ResponseEntity<Curso>(service.obtenerCursoPorId(id), HttpStatus.OK);
		}
		
		return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
	}
}
