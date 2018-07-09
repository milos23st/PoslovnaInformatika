package com.poslovna.service;

import com.poslovna.domain.Preduzece;

public interface PreduzeceService {
	
	Preduzece add(Preduzece p);

	Preduzece getByName(String string);

}
