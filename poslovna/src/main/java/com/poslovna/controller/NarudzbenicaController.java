package com.poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.domain.Narudzbenica;
import com.poslovna.service.NarudzbenicaService;

@RestController
public class NarudzbenicaController {
	
	@Autowired
	NarudzbenicaService narudzbenicaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Narudzbenica>> getAll(){
        List<Narudzbenica> narudzbenice = narudzbenicaService.findAll();
        return new ResponseEntity<>(narudzbenice, HttpStatus.OK);
    }

    @RequestMapping(value  = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Narudzbenica> getOne(@PathVariable Long id){
        Narudzbenica narudzbenica = narudzbenicaService.findOne(id);
        return new ResponseEntity<>(narudzbenica, HttpStatus.OK);
    }

    @RequestMapping(value  = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Narudzbenica> delete(@PathVariable Long id){
        Narudzbenica narudzbenica = narudzbenicaService.findOne(id);
        narudzbenicaService.delete(narudzbenica);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    

}
