package com.poslovna.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.Cenovnik;
import com.poslovna.repository.CenovnikRepository;
import com.poslovna.service.CenovnikService;
@Service
public class CenovnikServiceImpl implements CenovnikService {
	
	@Autowired
	CenovnikRepository repository;

	@Override
	public Cenovnik add(Cenovnik c) {
		return repository.save(c);
	}

	@Override
	public List<Cenovnik> findAll() {
		return repository.findAll();
	}

	@Override
	public Cenovnik findOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public boolean delete(Long id) {
		
		return false;
	}

	@Override
	public Cenovnik findNewest() {
		ArrayList<Cenovnik> lista = (ArrayList<Cenovnik>) repository.findAll();
		if(lista.isEmpty()) {
			return null;
		}
		Cenovnik c = lista.get(0);
		for(int i = 1; i<lista.size(); i++) {
			if(c.getDatumVazenja().getTime()<lista.get(i).getDatumVazenja().getTime()) {
				c = lista.get(i);
			}
		}
 		return c;
	}

	@Override
	public Cenovnik findActive(long currentTimeMillis) {
		ArrayList<Cenovnik> cenovnici = (ArrayList<Cenovnik>) repository.findAll();
		if(cenovnici == null || cenovnici.isEmpty()) {
			return null;
		}
		Cenovnik c = null;
		for(int i = 0; i<cenovnici.size(); i++) {
			if(cenovnici.get(i).getDatumVazenja().getTime()<=currentTimeMillis) {
				if(c!=null) {
					if(c.getDatumVazenja().getTime()<cenovnici.get(i).getDatumVazenja().getTime()) {
						c = cenovnici.get(i);
					}
				}
				else {
					c = cenovnici.get(i);
				}
			}
		}
		return c;
	}

	@Override
	public List<Cenovnik> findFuture(long currentTimeMillis) {
		return repository.findByDatumVazenjaGreaterThan(currentTimeMillis);
	}

}
