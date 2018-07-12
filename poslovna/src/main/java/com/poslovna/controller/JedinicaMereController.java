package com.poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.domain.JedinicaMere;
import com.poslovna.dto.JedinicaMereDTO;
import com.poslovna.service.JedinicaMereService;



@Controller
@RequestMapping(value="/jedinicaMere")
public class JedinicaMereController {
	
	@Autowired
	private JedinicaMereService service;
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public ResponseEntity<?> getCAll(){
		List<JedinicaMere> j = service.findAll();
		return new ResponseEntity<>(j, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> add(@RequestBody JedinicaMereDTO dto){
			
		JedinicaMere jm = new JedinicaMere();
		jm.setId(dto.getId());
		jm.setNaziv(dto.getNaziv());
		jm.setSkracenica(dto.getSkracenica());
		JedinicaMere retVal= service.add(jm);
		
		return new ResponseEntity<>(jm, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		JedinicaMere jm = service.getById(id);
		if (jm == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(jm, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = service.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody JedinicaMereDTO dto) {
		JedinicaMere jm = service.getById(dto.getId());
		jm.setId(dto.getId());
		jm.setNaziv(dto.getNaziv());
		jm.setSkracenica(dto.getSkracenica());
		JedinicaMere retVal= service.add(jm);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

}
