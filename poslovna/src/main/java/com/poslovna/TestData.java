package com.poslovna;

import java.time.Year;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poslovna.domain.Cenovnik;
import com.poslovna.domain.GrupaProizvoda;
import com.poslovna.domain.JedinicaMere;
import com.poslovna.domain.PDV;
import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.PoslovniPartner;
import com.poslovna.domain.Preduzece;
import com.poslovna.domain.Proizvod;
import com.poslovna.domain.StavkaCenovnika;
import com.poslovna.domain.Valuta;
import com.poslovna.service.CenovnikService;
import com.poslovna.service.GrupaProizvodaService;
import com.poslovna.service.JedinicaMereService;
import com.poslovna.service.PdvService;
import com.poslovna.service.PoslovnaGodinaService;
import com.poslovna.service.PoslovniPartnerService;
import com.poslovna.service.PreduzeceService;
import com.poslovna.service.ProizvodService;
import com.poslovna.service.StavkaCenovnikaService;
import com.poslovna.service.ValutaService;


@Component
public class TestData {
	@Autowired
	private PoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired
	private GrupaProizvodaService grupaProizvodaService;
	
	@Autowired
	private PreduzeceService preduzeceService;
	
	@Autowired
	private CenovnikService cenovnikService;
	
	@Autowired
	private JedinicaMereService jedinicaMereService;
	
	@Autowired 
	private ProizvodService proizvodService;
	
	@Autowired
	private StavkaCenovnikaService stavkaCenovnikaService;
	
	@Autowired
	private PoslovniPartnerService poslovniPartnerService;
	
	@Autowired
	private ValutaService valutaService;
	
	@Autowired
	private PdvService pdvService;
	
	@PostConstruct
	private void init() {
		PDV pdv1 = new PDV();
		pdv1.setNaziv("Opsti");
		PDV pdv2 = new PDV();
		pdv2.setNaziv("Subvencionisani");
		PDV pdv3 = new PDV();
		pdv3.setNaziv("Rigorozni"); 
		pdvService.addPDV(pdv1);
		pdvService.addPDV(pdv2);
		pdvService.addPDV(pdv3);
		
		GrupaProizvoda gp1 = new GrupaProizvoda();
		gp1.setNaziv("Elektronika");
		gp1.setPdv(pdv1);
		gp1.setOpis("uredjaji");
		GrupaProizvoda gp2 = new GrupaProizvoda();
		gp2.setNaziv("Hrana");
		gp2.setPdv(pdv2);
		gp2.setOpis("prehrambeni proizvodi");
		GrupaProizvoda gp3 = new GrupaProizvoda();
		gp3.setNaziv("Pice");
		gp3.setPdv(pdv3);
		gp3.setOpis("napitci");
		GrupaProizvoda gp4 = new GrupaProizvoda();
		gp4.setNaziv("Gradjevinski materijal");
		gp4.setPdv(pdv1);
		gp4.setOpis("materijali");
		grupaProizvodaService.add(gp1); 
		grupaProizvodaService.add(gp2); 
		grupaProizvodaService.add(gp3); 
		grupaProizvodaService.add(gp4); 
		
		Preduzece p = new Preduzece();
		p.setAdresa("Dunavska 31, Novi Sad");
		p.setNazivPreduzeca("Moj Dom");
		p.setEmail("mojdom@gmail.com");
		p.setPib("0210483328");
		preduzeceService.add(p);
		Preduzece p1 = new Preduzece();
		p1.setAdresa("Kisacka 55, Novi Sad");
		p1.setNazivPreduzeca("Gigatron");
		p1.setEmail("gigatron@gmail.com");
		p1.setPib("0210483328");
		preduzeceService.add(p1);
		
		Cenovnik c1 = new Cenovnik();
		c1.setDatumVazenja(new Date()); //2018-01-01
		Cenovnik c2 = new Cenovnik();
		c2.setDatumVazenja(new Date()); //2019-01-01
		cenovnikService.add(c1);
		cenovnikService.add(c2);
		
		JedinicaMere jm1 = new JedinicaMere();
		jm1.setNaziv("Tona");
		jm1.setSkracenica("t");
		JedinicaMere jm2 = new JedinicaMere();
		jm2.setNaziv("Kilogram");
		jm2.setSkracenica("kg");
		JedinicaMere jm3 = new JedinicaMere();
		jm3.setNaziv("Gram");
		jm3.setSkracenica("g");
		JedinicaMere jm4 = new JedinicaMere();
		jm4.setNaziv("Litar");
		jm4.setSkracenica("l");
		JedinicaMere jm5 = new JedinicaMere();
		jm5.setNaziv("Galon");
		jm5.setSkracenica("gal");
		JedinicaMere jm6 = new JedinicaMere();
		jm6.setNaziv("Metar");
		jm6.setSkracenica("m");
		JedinicaMere jm7 = new JedinicaMere();
		jm7.setNaziv("Komad");
		jm7.setSkracenica("kom");
		jedinicaMereService.add(jm1);
		jedinicaMereService.add(jm2);
		jedinicaMereService.add(jm3);
		jedinicaMereService.add(jm4);
		jedinicaMereService.add(jm5);
		jedinicaMereService.add(jm6);
		jedinicaMereService.add(jm7);
		
		Valuta va1 = new Valuta();
		va1.setNaziv("Evro");
		va1.setOznaka("EUR");
		Valuta va2 = new Valuta();
		va2.setNaziv("Srpski dinar");
		va2.setOznaka("RSD");
		Valuta va3 = new Valuta();
		va3.setNaziv("Americki dolar");
		va3.setOznaka("USD");
		Valuta va4 = new Valuta();
		va4.setNaziv("Svajcarski franak");
		va4.setOznaka("CHF");
		Valuta va5 = new Valuta();
		va5.setNaziv("Madjarska forinta");
		va5.setOznaka("HUF");
		valutaService.add(va1);
		valutaService.add(va2);
		valutaService.add(va3);
		valutaService.add(va4);
		valutaService.add(va5);
		
		
		
		Proizvod pr1 = new Proizvod();
		pr1.setNazivProizvoda("LG monitor");
		pr1.setJedinicaMere(jm7);
		pr1.setPreduzece(p);
		pr1.setOpis("uredjaj");
		pr1.setGrupaProizvod(gp1);
		Proizvod pr2 = new Proizvod();
		pr2.setNazivProizvoda("Genius mis");
		pr2.setJedinicaMere(jm7);
		pr2.setPreduzece(p);
		pr2.setOpis("uredjaj");
		pr2.setGrupaProizvod(gp1);
		Proizvod pr3 = new Proizvod();
		pr3.setNazivProizvoda("Ovsene pahuljice");
		pr3.setJedinicaMere(jm1);
		pr3.setPreduzece(p);
		pr3.setOpis("hrana");
		pr3.setGrupaProizvod(gp2);
		Proizvod pr4 = new Proizvod();
		pr4.setNazivProizvoda("Piletina");
		pr4.setJedinicaMere(jm2);
		pr4.setPreduzece(p);
		pr4.setOpis("hrana");
		pr4.setGrupaProizvod(gp2);
		Proizvod pr5 = new Proizvod();
		pr5.setNazivProizvoda("Coca Cola");
		pr5.setJedinicaMere(jm5);
		pr5.setPreduzece(p);
		pr5.setOpis("pice");
		pr5.setGrupaProizvod(gp3);
		Proizvod pr6 = new Proizvod();
		pr6.setNazivProizvoda("Napolitanke");
		pr6.setJedinicaMere(jm4);
		pr6.setPreduzece(p);
		pr6.setOpis("hrana");
		pr6.setGrupaProizvod(gp3);
		Proizvod pr7 = new Proizvod();
		pr7.setNazivProizvoda("Hleb");
		pr7.setJedinicaMere(jm4);
		pr7.setPreduzece(p);
		pr7.setOpis("hrana");
		pr7.setGrupaProizvod(gp2);
		Proizvod pr8 = new Proizvod();
		pr8.setNazivProizvoda("Krompir");
		pr8.setJedinicaMere(jm2);
		pr8.setPreduzece(p);
		pr8.setOpis("povrce");
		pr8.setGrupaProizvod(gp2);
		Proizvod pr9 = new Proizvod();
		pr9.setNazivProizvoda("Cigla");
		pr9.setJedinicaMere(jm2);
		pr9.setPreduzece(p);
		pr9.setOpis("materijal");
		pr9.setGrupaProizvod(gp4);
		Proizvod pr0 = new Proizvod();
		pr0.setNazivProizvoda("Pesak");
		pr0.setJedinicaMere(jm7);
		pr0.setPreduzece(p);
		pr0.setOpis("materijal");
		pr0.setGrupaProizvod(gp4);
		proizvodService.add(pr1);
		proizvodService.add(pr2);
		proizvodService.add(pr3);
		proizvodService.add(pr4);
		proizvodService.add(pr5);
		proizvodService.add(pr6);
		proizvodService.add(pr7);
		proizvodService.add(pr8);
		proizvodService.add(pr9);
		proizvodService.add(pr0);

		StavkaCenovnika sc1 = new StavkaCenovnika();
		sc1.setCenovnik(c1);
		sc1.setProizvod(pr1);
		sc1.setCena(7600);
		StavkaCenovnika sc2 = new StavkaCenovnika();
		sc2.setCenovnik(c1);
		sc2.setProizvod(pr2);
		sc2.setCena(600);
		StavkaCenovnika sc3 = new StavkaCenovnika();
		sc3.setCenovnik(c1);
		sc3.setProizvod(pr3);
		sc3.setCena(120);
		StavkaCenovnika sc4 = new StavkaCenovnika();
		sc4.setCenovnik(c1);
		sc4.setProizvod(pr4);
		sc4.setCena(500);
		StavkaCenovnika sc5 = new StavkaCenovnika();
		sc5.setCenovnik(c1);
		sc5.setProizvod(pr5);
		sc5.setCena(200);
		StavkaCenovnika sc6 = new StavkaCenovnika();
		sc6.setCenovnik(c1);
		sc6.setProizvod(pr6);
		sc6.setCena(300);
		StavkaCenovnika sc7 = new StavkaCenovnika();
		sc7.setCenovnik(c1);
		sc7.setProizvod(pr7);
		sc7.setCena(100);
		StavkaCenovnika sc8 = new StavkaCenovnika();
		sc8.setCenovnik(c1);
		sc8.setProizvod(pr8);
		sc8.setCena(40);
		StavkaCenovnika sc9 = new StavkaCenovnika();
		sc9.setCenovnik(c1);
		sc9.setProizvod(pr9);
		sc9.setCena(80);
		StavkaCenovnika sc0 = new StavkaCenovnika();
		sc0.setCenovnik(c1);
		sc0.setProizvod(pr0);
		sc0.setCena(10);
		StavkaCenovnika sc11 = new StavkaCenovnika();
		sc11.setCenovnik(c2);
		sc11.setProizvod(pr1);
		sc11.setCena(7800);
		StavkaCenovnika sc21 = new StavkaCenovnika();
		sc21.setCenovnik(c2);
		sc21.setProizvod(pr2);
		sc21.setCena(800);
		StavkaCenovnika sc31 = new StavkaCenovnika();
		sc31.setCenovnik(c2);
		sc31.setProizvod(pr3);
		sc31.setCena(140);
		StavkaCenovnika sc41 = new StavkaCenovnika();
		sc41.setCenovnik(c2);
		sc41.setProizvod(pr4);
		sc41.setCena(600);
		StavkaCenovnika sc51 = new StavkaCenovnika();
		sc51.setCenovnik(c2);
		sc51.setProizvod(pr5);
		sc51.setCena(210);
		StavkaCenovnika sc61 = new StavkaCenovnika();
		sc61.setCenovnik(c2);
		sc61.setProizvod(pr6);
		sc61.setCena(280);
		StavkaCenovnika sc71 = new StavkaCenovnika();
		sc71.setCenovnik(c2);
		sc71.setProizvod(pr7);
		sc71.setCena(110);
		StavkaCenovnika sc81 = new StavkaCenovnika();
		sc81.setCenovnik(c2);
		sc81.setProizvod(pr8);
		sc81.setCena(42);
		StavkaCenovnika sc91 = new StavkaCenovnika();
		sc91.setCenovnik(c2);
		sc91.setProizvod(pr9);
		sc91.setCena(88);
		StavkaCenovnika sc01 = new StavkaCenovnika();
		sc01.setCenovnik(c2);
		sc01.setProizvod(pr0);
		sc01.setCena(11);
		stavkaCenovnikaService.add(sc1);
		stavkaCenovnikaService.add(sc2);
		stavkaCenovnikaService.add(sc3);
		stavkaCenovnikaService.add(sc4);
		stavkaCenovnikaService.add(sc5);
		stavkaCenovnikaService.add(sc6);
		stavkaCenovnikaService.add(sc7);
		stavkaCenovnikaService.add(sc8);
		stavkaCenovnikaService.add(sc9);
		stavkaCenovnikaService.add(sc0);
		stavkaCenovnikaService.add(sc11);
		stavkaCenovnikaService.add(sc21);
		stavkaCenovnikaService.add(sc31);
		stavkaCenovnikaService.add(sc41);
		stavkaCenovnikaService.add(sc51);
		stavkaCenovnikaService.add(sc61);
		stavkaCenovnikaService.add(sc71);
		stavkaCenovnikaService.add(sc81);
		stavkaCenovnikaService.add(sc91);
		stavkaCenovnikaService.add(sc01);
		
		PoslovniPartner pp1 = new PoslovniPartner();
		pp1.setNaziv("Moj Dom");
		pp1.setBrojTelefona("02312351");
		pp1.setEmail("md@gmail.com");
		pp1.setAdresa("Radnicka 22");
		pp1.setBrojRacuna("160786");
		pp1.setPreduzece(p1);
		pp1.setVrsta(PoslovniPartner.VrstaPartnera.Kupac);
		PoslovniPartner pp2 = new PoslovniPartner();
		pp2.setAdresa("Kosovska 10, Novi Sad");
		pp2.setNaziv("Quanto");
		pp2.setBrojTelefona("021132441");
		pp2.setEmail("q@gmail.com");
		pp2.setBrojRacuna("160222");
		pp2.setPreduzece(p);
		pp2.setVrsta(PoslovniPartner.VrstaPartnera.Kupac);
		PoslovniPartner pp3 = new PoslovniPartner();
		pp3.setAdresa("Neka 2, Beograd");
		pp3.setNaziv("Moja Firma");
		pp3.setBrojTelefona("011312878");
		pp3.setEmail("f@gmail.com");
		pp3.setBrojRacuna("160333");
		pp3.setPreduzece(p1);
		pp3.setVrsta(PoslovniPartner.VrstaPartnera.Dobavljac);
		PoslovniPartner pp4 = new PoslovniPartner();
		pp4.setAdresa("Cvetna 23, Sr. Kamenica");
		pp4.setNaziv("Technocore");
		pp4.setBrojTelefona("02215123");
		pp4.setEmail("tt@gmail.com");
		pp4.setBrojRacuna("1605555");
		pp4.setPreduzece(p);
		pp4.setVrsta(PoslovniPartner.VrstaPartnera.Dobavljac);
		poslovniPartnerService.add(pp1);
		poslovniPartnerService.add(pp2);
		poslovniPartnerService.add(pp3);
		poslovniPartnerService.add(pp4);
		
		PoslovnaGodina pg1 = new PoslovnaGodina();
		pg1.setZakljucena(true);
		pg1.setPreduzece(p);
		pg1.setGodina(2016);
		PoslovnaGodina pg2 = new PoslovnaGodina();
		pg2.setZakljucena(true);
		pg2.setPreduzece(p);
		pg2.setGodina(2017);
		PoslovnaGodina pg3 = new PoslovnaGodina();
		pg3.setZakljucena(false);
		pg3.setPreduzece(p);
		pg3.setGodina(2018);
		poslovnaGodinaService.add(pg1);
		poslovnaGodinaService.add(pg2);
		poslovnaGodinaService.add(pg3);
	}

}
