import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CenovniciComponent } from './components/glavno/cenovnici/cenovnici.component';
import { Observable } from 'rxjs';
import { Cenovnik } from './components/models/cenovnik';
import { JedinicaMere } from './components/models/jedinica-mere';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': 'true' })
};

@Injectable({
  providedIn: 'root'
})

export class DataService {

  

  private heroesUrl = 'http://localhost:1234/api/cenovnik';

  private jedinicaMereUrl = 'http://localhost:1234/jedinicaMere';

  

  getHeroes (): Observable<CenovniciComponent[]> {
  return this.http.get<CenovniciComponent[]>(this.heroesUrl);
}
 preuzmiCenovnike(page, size) {
    return this.http.get("http://localhost:1234/api/cenovnik/pages?page="+page+"&size="+size, httpOptions);
  }

  getCenovnik(): Observable<Cenovnik[]> {
    return this.http.get<Cenovnik[]>(this.heroesUrl);

  }

  addJedMere(jedinicaMere: JedinicaMere): Observable<JedinicaMere> {
    return this.http.post<JedinicaMere>(this.jedinicaMereUrl, jedinicaMere, httpOptions);
  }

  getJedMere(): Observable<JedinicaMere[]> {
    return this.http.get<JedinicaMere[]>(this.jedinicaMereUrl);

  }
  constructor(private http: HttpClient) { }
}


