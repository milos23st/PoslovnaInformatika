package com.poslovna.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.domain.Cenovnik;
import com.poslovna.domain.IzlaznaFaktura;
import com.poslovna.domain.PDV;
import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.PoslovniPartner;
import com.poslovna.domain.Preduzece;
import com.poslovna.domain.Proizvod;
import com.poslovna.domain.StavkeFakture;
import com.poslovna.dto.FakturaDTO;
import com.poslovna.dto.NarudzbenicaDTO;
import com.poslovna.dto.StavkaFaktureDTO;
import com.poslovna.service.CenovnikService;
import com.poslovna.service.FakturaService;
import com.poslovna.service.PoslovnaGodinaService;
import com.poslovna.service.PoslovniPartnerService;
import com.poslovna.service.PreduzeceService;
import com.poslovna.service.ProizvodService;
import com.poslovna.service.StavkaCenovnikaService;
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
	
	@Autowired
	private PreduzeceService preduzeceService;
	
	@Autowired
	private CenovnikService cenovnikService;
	
	@Autowired
	private StavkaCenovnikaService stavkaCenovnikaService;
	
	
	@RequestMapping(method = RequestMethod.GET,value="/export/fakture/{id}")
	public void getXml(@PathVariable Long id, HttpServletResponse response)
	{
		IzlaznaFaktura novaFaktura = fakturaService.getById(id);
		long derp =5;
		try
		{
			JAXBContext context = JAXBContext.newInstance(IzlaznaFaktura.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			StringWriter sw = new StringWriter();
			marshaller.marshal(novaFaktura, sw);

		    HashMap<String, String> retVal = new HashMap<>();
		    byte[] a = sw.toString().getBytes();
		    OutputStream out = new FileOutputStream("out.xml");
			out.write(a);
			out.close();

			File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "out.xml");
			if (file.exists()) {

				//get the mimetype
				String mimeType = URLConnection.guessContentTypeFromName(file.getName());
				if (mimeType == null) {
					//unknown mimetype so set the mimetype to application/octet-stream
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);
				response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

				 //Here we have mentioned it to show as attachment
				 //response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

				response.setContentLength((int) file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

				FileCopyUtils.copy(inputStream, response.getOutputStream());

			}

	    } catch (Exception ex) {

	        System.out.println(ex.toString());
	    }
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/fakture/{id:\\d+}")
	public ResponseEntity<ArrayList<IzlaznaFaktura>> getFaktureIzGodine(@PathVariable Long id)
	{
		PoslovnaGodina pg = poslovnaGodinaService.findOne(id);
		return new ResponseEntity<ArrayList<IzlaznaFaktura>>(fakturaService.getFaktureIzGodine(pg), HttpStatus.OK);
	}
	
	@GetMapping("/stavke")
	public ResponseEntity<List<StavkaFaktureDTO>> getStavke() {
		ArrayList<StavkaFaktureDTO> stavke = new ArrayList<>();
		ArrayList<Proizvod> proizvodi = proizvodService.findAll();
		for(int i = 0; i<proizvodi.size(); i++) {
			StavkaFaktureDTO sDTO = new StavkaFaktureDTO();
			sDTO.setProizvod(proizvodi.get(i));
			PDV pdv = proizvodi.get(i).getGrupaProizvod().getPdv();
			Cenovnik c = cenovnikService.findActive(System.currentTimeMillis());
			sDTO.setCena(stavkaCenovnikaService.findCenaByCenovnikAndProizvod(c, proizvodi.get(i)));
			sDTO.setPdv(sDTO.getCena()*sDTO.getStopaPDV()/100);
			sDTO.setStopaPDV(10);
			sDTO.setKolicina((long) 0);
			stavke.add(sDTO);
			}
		if(stavke == null || stavke.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(stavke, HttpStatus.OK);
	}
	@GetMapping("/partneri")
	public ResponseEntity<ArrayList<PoslovniPartner>> getPoslovniPartneri()
	{
		return new ResponseEntity<ArrayList<PoslovniPartner>>(poslovniPartnerService.findAllKupac(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/fakture")
	public ResponseEntity<ArrayList<IzlaznaFaktura>> getFakture() 
	{
		return new ResponseEntity<ArrayList<IzlaznaFaktura>>(fakturaService.findAll(), HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/fakture")
	public ResponseEntity<Long> postFakture(@RequestBody NarudzbenicaDTO narudzbenicaDTO)
	{
		Long idNoveFaktura = generate(narudzbenicaDTO,preduzeceService.getByName("Moj Dom"));



		return new ResponseEntity<Long>(idNoveFaktura, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getFaktura(@PathVariable Long id) {
		IzlaznaFaktura retVal = fakturaService.getById(id);
		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = fakturaService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody FakturaDTO dto) {
		IzlaznaFaktura f = fakturaService.getById(dto.getId());
		f.setBezPDV(dto.getBezPDV());
		f.setBroj(dto.getBroj());
		f.setBrojFakture(dto.getBrojFakture());
		f.setDatumFakture(dto.getDatumFakture());
		f.setDatumObracuna(dto.getDatumObracuna());
		f.setDatumValute(dto.getDatumValute());
		f.setIznosFakture(dto.getIznosFakture());
		f.setPoslovnaGodina(poslovnaGodinaService.findOne(dto.getPoslovnaGodinaId()));
		f.setPoslovniPartner(poslovniPartnerService.getById(dto.getId()));
		f.setPozivNaBroj(dto.getPozivNaBroj());
		f.setPreduzece(preduzeceService.getById(dto.getPreduzeceId()));
		f.setUkupanPorez(dto.getUkupanPorez());
		f.setUkupanRabat(dto.getUkupanRabat());
		f.setUkupnoRobaIUsluge(dto.getUkupnoRobaIUsluge());
		f.setUplataNaRacun(dto.getUplataNaRacun());
		IzlaznaFaktura retVal = fakturaService.add(f);
		return new ResponseEntity<>(f, HttpStatus.OK);
	}
	
	
	public Long generate(NarudzbenicaDTO narudzbenica, Preduzece preduzece)
	{
		IzlaznaFaktura faktura = new IzlaznaFaktura();

		final Calendar cal = Calendar.getInstance();

		faktura.setDatumFakture(cal.getTime());
		faktura.setDatumFaktureLong(cal.getTimeInMillis());
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
		if(fakture.isEmpty()) {
			System.out.println("NOPE");
			return new Long(0);
		}
		ArrayList<Long> brojevi = new ArrayList<Long>();
		for(IzlaznaFaktura faktura: fakture) {
			brojevi.add(faktura.getBroj());
		}
		
		Long max = Collections.max(brojevi);
		System.out.println(max+1);
		return max+1;
		
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
		retVal.setKolicina(stavkaFakture.getKolicina());
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
