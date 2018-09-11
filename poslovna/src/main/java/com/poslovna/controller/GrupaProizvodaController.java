package com.poslovna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.domain.GrupaProizvoda;
import com.poslovna.dto.GrupaProizvodaDTO;
import com.poslovna.service.GrupaProizvodaService;


@Controller
@RequestMapping(value="/grupa")
public class GrupaProizvodaController {
	
	@Autowired
	private GrupaProizvodaService service;
	
	@RequestMapping(value="getGroups", method=RequestMethod.GET)
	public ResponseEntity<?> getGroups(){
		List<GrupaProizvoda> groups = service.findAll();
		return new ResponseEntity<>(groups, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> addGroup(@RequestBody GrupaProizvodaDTO dto){
		GrupaProizvoda grupa = new GrupaProizvoda();	
		grupa.setId(dto.getId());
		grupa.setNaziv(dto.getNaziv());
		grupa.setOpis(dto.getOpis());
		//grupa.setPdv(dto.getPdv());
		service.add(grupa);
		return new ResponseEntity<>(grupa, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getGroup(@PathVariable Long id) {
		GrupaProizvoda grupa = service.getById(id);

		return new ResponseEntity<>(grupa, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = service.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody GrupaProizvoda dto) {
		GrupaProizvoda grupa = service.getById(dto.getId());
		grupa.setNaziv(dto.getNaziv());
		grupa.setOpis(dto.getOpis());
		grupa.setPdv(dto.getPdv());
		GrupaProizvoda retVal = service.add(grupa);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

}
