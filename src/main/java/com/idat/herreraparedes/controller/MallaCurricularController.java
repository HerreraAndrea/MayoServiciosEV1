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

import com.idat.herreraparedes.model.MallaCurricular;
import com.idat.herreraparedes.service.MallaCurricularServiceImpl;


@Controller
@RequestMapping("/malla/v1")
public class MallaCurricularController {
	
	@Autowired
	private MallaCurricularServiceImpl service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<MallaCurricular>> listar() {
		return new ResponseEntity<List<MallaCurricular>>(service.listarMallaCurricular(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCurricular mallaCurricular) {
		service.guardarMallaCurricular(mallaCurricular);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarMallaCurricular(@PathVariable Integer id) {
		
		MallaCurricular m = service.obtenerMallaCurricularPorId(id);
		
		if(m != null) {
			service.eliminarMallaCurricular(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarMallaCurricular(@RequestBody MallaCurricular mallaCurricular) {
		
		MallaCurricular m = service.obtenerMallaCurricularPorId(mallaCurricular.getIdMalla());
		
		if(m != null) {
			service.actualizarMallaCurricular(mallaCurricular);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);// Create, Ok, No_content son mensajes que devuelva
	}
	
	
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<MallaCurricular> obtenerProductoPorId(@PathVariable Integer id) {
		MallaCurricular m = service.obtenerMallaCurricularPorId(id);
		
		if(m != null) {
			return new ResponseEntity<MallaCurricular>(service.obtenerMallaCurricularPorId(id), HttpStatus.OK);
		}
		
		return new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);
	}
}
