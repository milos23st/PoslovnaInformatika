package com.poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.domain.PDV;
import com.poslovna.service.PdvService;

@Controller
@RequestMapping(value="/pdv")
public class PdvController {
	
	@Autowired
	private PdvService service;
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		List<PDV> p = service.findAll();
		return new ResponseEntity<>(p, HttpStatus.OK);		
	}	
	
	

}
