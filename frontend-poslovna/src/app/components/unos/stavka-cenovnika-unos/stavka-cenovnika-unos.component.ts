import { Component, OnInit } from '@angular/core';
import { Proizvod } from '../../models/proizvod';
import { Cenovnik } from '../../models/cenovnik';
import { DataService } from '../../../data.service';
import { FakturaService } from '../../narudzbenica/faktura.service';
import { StavkaCenovnika } from '../../models/stavkacenovnika';

@Component({
  selector: 'app-stavka-cenovnika-unos',
  templateUrl: './stavka-cenovnika-unos.component.html',
  styleUrls: ['./stavka-cenovnika-unos.component.css']
})
export class StavkaCenovnikaUnosComponent implements OnInit {
  proizvodi: Proizvod[];
  cenovnici: Cenovnik[];
  stavka: StavkaCenovnika;
  cI: number;
  pI: number;
  constructor(
    private cenovnikService: DataService,
    private fakturaService: FakturaService
  ) { }

  ngOnInit() {
    this.stavka = new StavkaCenovnika(null, null, null);
    this.cenovnikService.getCenovnik().subscribe(
      data => {
        this.cenovnici = data;
      }
    );
    this.fakturaService.getProizvodi().subscribe(
      data => {
        this.proizvodi = data;
      }
    );
  }
  addStavka(){
    this.stavka.proizvod = this.proizvodi[this.pI];
    this.fakturaService.addStavkaCenovnika(this.stavka, +this.cenovnici[this.cI].id).subscribe();
  }

}
