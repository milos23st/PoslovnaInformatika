import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Cenovnik } from '../../models/cenovnik';
import { StavkaCenovnika } from '../../models/stavkacenovnika';
import { Proizvod } from '../../models/proizvod';

const httpOptions = {
        headers: new HttpHeaders({ 'Content-type': 'application/json'})
      };
@Injectable({
  providedIn: 'root'
})
export class CenovnikService {

  constructor(private http: HttpClient) { }

  getCenovnici(): Observable<Cenovnik[]>{
    return this.http.get<Cenovnik[]>('http://localhost:8080/api/cenovnik', httpOptions);
  }
  getStavke(id: number): Observable<StavkaCenovnika[]> {
    return this.http.get<StavkaCenovnika[]>('http://localhost:1234/api/cenovnik/stavke/'+ id, httpOptions);
  }
  addCenovnik(id: number, stavke: StavkaCenovnika[], datum: number): Observable<Cenovnik> {
    return this.http.post<Cenovnik>('http://localhost:1234/api/cenovnik/' + id, stavke, httpOptions);
  }
  deleteStavka(id: number): Observable<boolean>{
    return this.http.delete<boolean>('http://localhost:1234/api/cenovnik/'+id,httpOptions);
  }
  getProizvodi(): Observable<Proizvod[]>{
    return this.http.get<Proizvod[]>('http://localhost:1234/proizvod/getAll', httpOptions);
  }


}
