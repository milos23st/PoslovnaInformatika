import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CenovniciComponent } from './components/glavno/cenovnici/cenovnici.component';
import { Observable } from 'rxjs';
import { Cenovnik } from './components/models/cenovnik';
import { JedinicaMere } from './components/models/jedinica-mere';
import { Preduzece } from './components/models/preduzece';
import { Valuta } from './components/models/Valuta';
import { Pdv } from './components/models/pdv';
import { GrupaProizvoda } from './components/models/grupa-proizvoda';
import { PoslovniPartner } from './components/models/poslovni-partner';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'true' })
};

@Injectable({
  providedIn: 'root'
})

export class DataService {



  private heroesUrl = 'http://localhost:1234/api/cenovnik';

  private jedinicaMereUrl = 'http://localhost:1234/jedinicaMere';

  private preduzeceUrl = 'http://localhost:1234/preduzece';

  private valutaUrl = 'http://localhost:1234/valuta';

  private pdvUrl = 'http://localhost:1234/pdv';

  private grupaUrl = 'http://localhost:1234/grupa';

  private poslovniPartUrl = 'http://localhost:1234/poslovniPartner'



  getHeroes (): Observable<CenovniciComponent[]> {
  return this.http.get<CenovniciComponent[]>(this.heroesUrl);
}
 preuzmiCenovnike(page, size) {
    return this.http.get('http://localhost:1234/api/cenovnik', httpOptions);
  }

  getCenovnik(): Observable<Cenovnik[]> {
    return this.http.get<Cenovnik[]>(this.heroesUrl);

  }
// jedinica mere
  addJedMere(jedinicaMere: JedinicaMere): Observable<JedinicaMere> {
    return this.http.post<JedinicaMere>(this.jedinicaMereUrl, jedinicaMere, httpOptions);
  }

  getJedMere(): Observable<JedinicaMere[]> {
    return this.http.get<JedinicaMere[]>(this.jedinicaMereUrl + '/getAll');

  }
// jedinica mere- kraj


// preduzece
  addPreduzece(preduzece: Preduzece): Observable<Preduzece> {
      return this.http.post<Preduzece>(this.preduzeceUrl, preduzece, httpOptions);
    }
  getPreduzece(): Observable<Preduzece[]> {
      return this.http.get<Preduzece[]>(this.preduzeceUrl + '/getAll');
  }

// preduzece- kraj

// valuta - pocetak

  addValute(valuta: Valuta): Observable<Valuta> {
    return this.http.post<Valuta>(this.valutaUrl, valuta, httpOptions);
  }

  getValute(): Observable<Valuta[]> {
    return this.http.get<Valuta[]>(this.valutaUrl + '/getAll');

  }

// valuta - kraj

// pdv - pocetak

 addPdv(pdv: Pdv): Observable<Pdv> {
    return this.http.post<Pdv>(this.pdvUrl, pdv, httpOptions);
  }

  getPdv(): Observable<Pdv[]> {
    return this.http.get<Pdv[]>(this.pdvUrl + '/getAll');

  }

// pdv - kraj

// grupaProizvoda - pocetak

  addGrupaProizvoda(grupaProizvoda: GrupaProizvoda): Observable<GrupaProizvoda> {
    return this.http.post<GrupaProizvoda>(this.grupaUrl, grupaProizvoda, httpOptions);
  }

  getGrupeProizvoda(): Observable<GrupaProizvoda[]> {
    return this.http.get<GrupaProizvoda[]>(this.grupaUrl + '/getGroups');

  }

// grupaProizvoda - kraj

// poslovni partner - pocetak

  addPoslovniPart(poslovniPartner: PoslovniPartner): Observable<PoslovniPartner> {
    return this.http.post<PoslovniPartner>(this.poslovniPartUrl, poslovniPartner, httpOptions);
  }

  getPoslovniPartneri(): Observable<PoslovniPartner[]> {
    return this.http.get<PoslovniPartner[]>(this.poslovniPartUrl + '/getPoslovniPartneri');

  }


// poslovni partner - kraj

  constructor(private http: HttpClient) { }
}



