package com.poslovna.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.domain.IzlaznaFaktura;
import com.poslovna.domain.PoslovniPartner;
import com.poslovna.domain.Preduzece;
import com.poslovna.domain.StavkeFakture;
import com.poslovna.dto.NarudzbenicaDTO;
import com.poslovna.dto.StavkaFaktureDTO;
import com.poslovna.service.FakturaService;
import com.poslovna.service.PoslovnaGodinaService;
import com.poslovna.service.PoslovniPartnerService;
import com.poslovna.service.ProizvodService;
import com.poslovna.service.StavkaFaktureService;

@RestController
@RequestMapping("/api")
public class FakturaController {
	
	@Autowired
	private FakturaService fakturaService;
	
	@Autowired
	private PoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	private PoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired
	private ProizvodService proizvodService;
	
	@Autowired
	private StavkaFaktureService stavkaFaktureService;
	
	@RequestMapping(method = RequestMethod.GET,value="/fakture")
	public ResponseEntity<ArrayList<IzlaznaFaktura>> getFakture() 
	{
		return new ResponseEntity<ArrayList<IzlaznaFaktura>>(fakturaService.findAll(), HttpStatus.OK);	
	}
	
	
	public Long generate(NarudzbenicaDTO narudzbenica, Preduzece preduzece)
	{
		IzlaznaFaktura faktura = new IzlaznaFaktura();

		final Calendar cal = Calendar.getInstance();

		faktura.setDatumFakture(cal.getTime());
		Date date = new Date();
		cal.setTime(date);   // assigns calendar to given date
		int sat =cal.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
		if( sat<8)
		{
			cal.add(Calendar.DATE, -1);
			faktura.setDatumValute(cal.getTime());
		}else
		{
			faktura.setDatumValute(faktura.getDatumFakture());
		}
		faktura.setPreduzece(preduzece);
		faktura.setPoslovniPartner(poslovniPartnerService.getById(narudzbenica.getIdPoslovnogPartnera()));
		faktura.setBrojFakture("Broj fakture: " + getBroj(poslovniPartnerService.getById(narudzbenica.getIdPoslovnogPartnera())));
		faktura.setBroj(getBroj(poslovniPartnerService.getById(narudzbenica.getIdPoslovnogPartnera())));
		faktura.setPoslovnaGodina(poslovnaGodinaService.getNezakljucenaZaPreduzece(preduzece));

		ArrayList<StavkeFakture> stavke = new ArrayList<StavkeFakture>();
		double rabat = sracunajRabatNarudzbenice(narudzbenica.getStavke());
		for (StavkaFaktureDTO stavkaFakture : narudzbenica.getStavke())
		{
			if(stavkaFakture.getKolicina()>0)
			{
			stavke.add(napraviStavku(stavkaFakture, rabat));
			}
		}
		double ukupnoRabat =0;
		double ukupnoBezPDV=0;
		double ukupanPDV=0;
		double ukupno = 0;
		for (StavkeFakture stavkaFakture : stavke)
		{
			ukupnoRabat+=stavkaFakture.getRabat();
			ukupnoBezPDV+=(stavkaFakture.getOsnovica());
			ukupanPDV+=stavkaFakture.getIznosPDV();
			ukupno +=stavkaFakture.getUkupanIznos();
		}
		faktura.setUkupanRabat(ukupnoRabat);
		faktura.setBezPDV(ukupnoBezPDV);
		faktura.setUkupanPorez(ukupanPDV);
		faktura.setIznosFakture(ukupno);

		IzlaznaFaktura retVal =fakturaService.add(faktura);
		for (StavkeFakture stavkaFakture : stavke)
		{
			stavkaFakture.setFaktura(faktura);
			stavkaFaktureService.add(stavkaFakture);
		}



		return retVal.getId();
	}
	
	public Long getBroj(PoslovniPartner pp) {
		ArrayList<IzlaznaFaktura> fakture = fakturaService.getFakture(pp);
		ArrayList<Long> brojevi = new ArrayList<Long>();
		for(IzlaznaFaktura faktura: fakture) {
			brojevi.add(faktura.getBroj());
		}
		Long max = Collections.max(brojevi);
		return max++;
		
	}
	private double sracunajRabatNarudzbenice(ArrayList<StavkaFaktureDTO> stavke) {
		// TODO Auto-generated method stub
		double maxRabat=14.0; //Maksimalni moguci rabat na kolicinu
		double trazenaCena=200000; //Cena potrebna za ostavernje maksimalnog moguceg rabata

		double ostvarenaCena=0;

		for (StavkaFaktureDTO stavkaFaktureDTO : stavke)
		{
			ostvarenaCena+=stavkaFaktureDTO.getCena()*stavkaFaktureDTO.getKolicina();
		}
		if(ostvarenaCena>trazenaCena)
		{
			return maxRabat;
		}


		return (ostvarenaCena/trazenaCena)*maxRabat;
	}
	
	private StavkeFakture napraviStavku(StavkaFaktureDTO stavkaFakture, double rabat) {
		// TODO Auto-generated method stub
		StavkeFakture retVal = new StavkeFakture();
		retVal.setKolicina(new Long((int)stavkaFakture.getKolicina()));
		retVal.setProizvod(proizvodService.getById(stavkaFakture.getProizvod().getId()));

		retVal.setJedinicnaCena(stavkaFakture.getCena());
		retVal.setStopaPDV(stavkaFakture.getStopaPDV());

		double vrednostStavke = stavkaFakture.getCena()*stavkaFakture.getKolicina();
		retVal.setRabat(vrednostStavke*(rabat)/100);
		retVal.setOsnovica(vrednostStavke - retVal.getRabat());
		retVal.setIznosPDV(retVal.getOsnovica()*retVal.getStopaPDV()/100);
		retVal.setUkupanIznos(retVal.getOsnovica()+retVal.getIznosPDV());

		return retVal;
	}
	

}
