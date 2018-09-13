package com.poslovna.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.domain.Cenovnik;
import com.poslovna.domain.StavkaCenovnika;
import com.poslovna.dto.CenovnikDTO;
import com.poslovna.dto.StavkaCenovnikaDTO;
import com.poslovna.service.CenovnikService;
import com.poslovna.service.StavkaCenovnikaService;





@RestController
@RequestMapping("/api/cenovnik")
public class CenovnikController {
	
	@Autowired
	private CenovnikService cenovnikService;
	
	@Autowired
	private StavkaCenovnikaService stavkaService;
	
	
	@GetMapping
	public ResponseEntity<List<Cenovnik>> getAll() {
		List<Cenovnik> cenovnici = cenovnikService.findAll();
		if(cenovnici == null || cenovnici.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cenovnici, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cenovnik> getCenovnik(@PathVariable Long id) {
		Cenovnik cenovnik = cenovnikService.findOne(id);
		if(cenovnik == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cenovnik, HttpStatus.OK);
	}
	
	@PostMapping("/newCenovnik")
	public ResponseEntity<?> addNewCenovnik(@RequestBody CenovnikDTO dto){
		Cenovnik c = new Cenovnik();
		c.setDatumVazenja(dto.getDatum());
		cenovnikService.add(c);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@PostMapping("/newStavka/{id}")
	public ResponseEntity<?> addNewStavka(@RequestBody StavkaCenovnikaDTO dto, @PathVariable Long id){
		StavkaCenovnika sc = new StavkaCenovnika();
		sc.setId(dto.getId());
		sc.setCenovnik(cenovnikService.findOne(id));
		sc.setProizvod(dto.getProizvod());
		sc.setCena(dto.getCena());
		stavkaService.add(sc);
		return new ResponseEntity<>(sc, HttpStatus.OK);
		
		
	}
	
	@PostMapping("/{id:\\d+}")
	public ResponseEntity<Cenovnik> addCenovnik(@PathVariable Long id, @RequestBody StavkaCenovnikaDTO[] stavke) {
		Cenovnik c = new Cenovnik();
		Cenovnik cn = cenovnikService.findOne(id);
		c.setDatumVazenja(new Date());
		cenovnikService.add(c);
		for(int i = 0; i<stavke.length; i++) {
			StavkaCenovnika sc = new StavkaCenovnika();
			sc.setCenovnik(c);
			sc.setProizvod(stavke[i].getProizvod());
			double staraCena = stavkaService.findCenaByCenovnikAndProizvod(cn, stavke[i].getProizvod());
			sc.setCena(stavke[i].getProcenat()
					*staraCena/100+staraCena);
			stavkaService.add(sc);
		}
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@GetMapping("/stavke/{id}")
	public ResponseEntity<List<StavkaCenovnika>> getStavke(@PathVariable Long id) {
		Cenovnik c = cenovnikService.findOne(id);
		ArrayList<StavkaCenovnika> lista = stavkaService.findByCenovnik(c);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = stavkaService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}

}
