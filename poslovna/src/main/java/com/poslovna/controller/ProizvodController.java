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

import com.poslovna.domain.Preduzece;
import com.poslovna.domain.Proizvod;
import com.poslovna.dto.PreduzeceDTO;
import com.poslovna.dto.ProizvodDTO;
import com.poslovna.service.GrupaProizvodaService;
import com.poslovna.service.JedinicaMereService;
import com.poslovna.service.PreduzeceService;
import com.poslovna.service.ProizvodService;

@Controller
@RequestMapping(value="/proizvod")
public class ProizvodController {
	
	@Autowired
	private PreduzeceService preduzeceService;
	
	@Autowired
	private JedinicaMereService jedinicaService;
	
	@Autowired
	private GrupaProizvodaService grupaService;
	
	@Autowired
	private ProizvodService proizvodService;
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public ResponseEntity<?> getCAll(){
		List<Proizvod> p = proizvodService.findAll();
		return new ResponseEntity<>(p, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> add(@RequestBody ProizvodDTO dto){
			
		Proizvod p = new Proizvod();
		p.setGrupaProizvod(grupaService.getById(dto.getGrupaProizvod().getId()));
		p.setId(dto.getId());
		p.setJedinicaMere(jedinicaService.getById(dto.getJedinicaMere().getId()));
		p.setNazivProizvoda(dto.getNazivProizvoda());
		p.setOpis(dto.getOpis());
		p.setPreduzece(preduzeceService.getById(dto.getPreduzece().getId()));
		Proizvod retVal = proizvodService.add(p);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		Proizvod p = proizvodService.getById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = proizvodService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody ProizvodDTO dto) {
		Proizvod p = proizvodService.getById(dto.getId());
		p.setGrupaProizvod(grupaService.getById(dto.getGrupaProizvod().getId()));
		p.setId(dto.getId());
		p.setJedinicaMere(jedinicaService.getById(dto.getJedinicaMere().getId()));
		p.setNazivProizvoda(dto.getNazivProizvoda());
		p.setOpis(dto.getOpis());
		p.setPreduzece(preduzeceService.getById(dto.getPreduzece().getId()));
		Proizvod retVal = proizvodService.add(p);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

}
