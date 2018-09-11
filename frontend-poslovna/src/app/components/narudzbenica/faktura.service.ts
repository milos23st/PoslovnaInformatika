import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { StavkaFakture } from '../models/stavka-fakture';
import { PoslovniPartner } from '../models/poslovni-partner';
import { Narudzbenica } from '../models/narudzbenica';
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
}
