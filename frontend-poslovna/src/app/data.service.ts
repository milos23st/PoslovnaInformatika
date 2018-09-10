import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CenovniciComponent } from './components/glavno/cenovnici/cenovnici.component';
import { Observable } from 'rxjs';
import { Cenovnik } from './components/models/cenovnik';
import { JedinicaMere } from './components/models/jedinica-mere';
import { Preduzece } from './components/models/preduzece';

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
    return this.http.get<JedinicaMere[]>(this.jedinicaMereUrl +'/getAll');

  }
// jedinica mere- kraj
  
  
// preduzece
  addPreduzece(preduzece: Preduzece): Observable<Preduzece> {
      return this.http.post<Preduzece>(this.preduzeceUrl, preduzece, httpOptions);
    }
  getPreduzece(): Observable<Preduzece[]> {
      return this.http.get<Preduzece[]>(this.preduzeceUrl + '/getAll')
  }
  
// preduzece- kraj
  constructor(private http: HttpClient) { }
}


