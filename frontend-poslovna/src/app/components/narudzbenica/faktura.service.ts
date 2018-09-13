import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { StavkaFakture } from '../models/stavka-fakture';
import { PoslovniPartner } from '../models/poslovni-partner';
import { Narudzbenica } from '../models/narudzbenica';
import { Faktura } from '../models/faktura';
import { PoslovnaGodina } from '../models/poslovna-godina';
import { Izvestaj } from '../models/izvestaj';
import { Proizvod } from '../models/proizvod';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class FakturaService {

  constructor(private http: HttpClient) { }

  getStavke(): Observable<StavkaFakture[]>{
    return this.http.get<StavkaFakture[]>('http://localhost:1234/api/stavke', httpOptions);
  }
  getPartneri(): Observable<PoslovniPartner[]>{
    return this.http.get<PoslovniPartner[]>('http://localhost:1234/api/partneri', httpOptions);
  }
  naruci(narudzbenica: Narudzbenica): Observable<number>{
    return this.http.post<number>('http://localhost:1234/api/fakture', narudzbenica, httpOptions);
  }
  getFaktureIzGodine(id: number): Observable<Faktura[]>{
    return this.http.get<Faktura[]>('http://localhost:1234/api/fakture/' + id, httpOptions);
  }
  getPoslovneGodine(): Observable<PoslovnaGodina[]>{
    return this.http.get<PoslovnaGodina[]>('http://localhost:1234/poslovnaGodina/getAll', httpOptions);
  }
  getIzvestaj(id: number): Observable<Izvestaj>{
    return this.http.get<Izvestaj>('http://localhost:1234/api/izvestaj/FSS/' + id, httpOptions);
  }
  getXML(id: number): Observable<number>{
    return this.http.get<number>('http://localhost:1234/api/export/fakture/' + id, httpOptions);
  }
  getKnjiga(fromDate: number, toDate: number): Observable<number>{
    return this.http.get<number>('http://localhost:1234/api/izvestaj/KIF/' + fromDate + '/' + toDate);
  }
  getProizvodi(): Observable<Proizvod[]>{
    return this.http.get<Proizvod[]>('http://localhost:1234/proizvod/getAll', httpOptions);
  }
  addProizvod(proizvod: Proizvod): Observable<Proizvod>{
    return this.http.post<Proizvod>('http://localhost:1234/proizvod/', proizvod, httpOptions);
  }
}