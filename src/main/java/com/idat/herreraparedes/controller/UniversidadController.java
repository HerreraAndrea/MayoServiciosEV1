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

import com.idat.herreraparedes.model.Universidad;
import com.idat.herreraparedes.service.UniversidadServiceImpl;

@Controller
@RequestMapping("/universidad/v1")
public class UniversidadController {
	@Autowired
	private UniversidadServiceImpl service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Universidad>> listarUniversidad() {
		return new ResponseEntity<List<Universidad>>(service.listarUniversidad(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarProfesor(@RequestBody Universidad universidad) {
		service.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarUniversidad(@PathVariable Integer id) {
		
		Universidad univ = service.obtenerUniversidadPorId(id);
		
		if(univ != null) {
			service.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarUniversidad(@RequestBody Universidad universidad) {
		
		Universidad univ = service.obtenerUniversidadPorId(universidad.getIdUniversidad());
		
		if(univ != null) {
			service.actualizarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Universidad> obtenerUniversidadPorId(@PathVariable Integer id) {
		Universidad univ = service.obtenerUniversidadPorId(id);
		if(univ != null) {
			return new ResponseEntity<Universidad>(service.obtenerUniversidadPorId(id), HttpStatus.OK);
		}
		
		return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
	}
}
