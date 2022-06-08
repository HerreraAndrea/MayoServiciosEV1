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

import com.idat.herreraparedes.model.Profesor;
import com.idat.herreraparedes.service.ProfesorServiceImpl;

@Controller
@RequestMapping("/profesor/v1")
public class ProfesorController {
	@Autowired
	private ProfesorServiceImpl service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Profesor>> listarProfesor() {
		return new ResponseEntity<List<Profesor>>(service.listarProfesor(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarProfesor(@RequestBody Profesor profesor) {
		service.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarProfesor(@PathVariable Integer id) {
		
		Profesor p = service.obtenerProfesorPorId(id);
		
		if(p != null) {
			service.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	
	}
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarProfesor(@RequestBody Profesor profesor) {
		
		Profesor p= service.obtenerProfesorPorId(profesor.getIdProfesor());
		
		if(p != null) {
			service.actualizarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable Integer id) {
		Profesor p = service.obtenerProfesorPorId(id);
		
		if(p != null) {
			return new ResponseEntity<Profesor>(service.obtenerProfesorPorId(id), HttpStatus.OK);
		}
		
		return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
	}
}
