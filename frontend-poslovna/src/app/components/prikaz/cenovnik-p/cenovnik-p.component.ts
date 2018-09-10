import { Component, OnInit } from '@angular/core';
import { DataService } from './../../../data.service';
import { Cenovnik } from '../../models/cenovnik';
import { CenovnikService } from './cenovnik.service';
import { NgForm } from '@angular/forms';
import { StavkaCenovnika } from '../../models/stavkacenovnika';
@Component({
  selector: 'app-cenovnik-p',
  templateUrl: './cenovnik-p.component.html',
  styleUrls: ['./cenovnik-p.component.css'],
  providers: [ DataService ]
})
export class CenovnikPComponent implements OnInit {

  iterator;
  selektovanaStranica: number;
  brojStranica = 5;
  cenovnici: Cenovnik[];
  selectedCenovnik: number;
  stavke: StavkaCenovnika[];
  stavkeOut: StavkaCenovnika[];
  procenti: number[];
  unos = false;
  searchText = '';
  constructor(
    private service: DataService,
    private cenovnikService: CenovnikService
  ) { }

  ngOnInit() {
    this.selektovanaStranica = 0;
    this.selectedCenovnik = 1;
    this.showStavke();
    this.service.preuzmiCenovnike(0, this.brojStranica).subscribe(
      (data: any) => {
        this.cenovnici = data;
        this.iterator = Array(data.totalPages).fill(0).map((x, i) => i);
      }
    );

  }
  addCenovnik() {
      let today = new Date();
      let today1 = today.getDate();
      this.cenovnikService.addCenovnik(this.selectedCenovnik, this.stavkeOut, today1).subscribe();
      this.service.preuzmiCenovnike(0, this.brojStranica).subscribe(
      (data: any) => {
        this.cenovnici = data;
        this.iterator = Array(data.totalPages).fill(0).map((x, i) => i);
      }
    );
      this.toggleUnos();
  }
  toggleUnos(){
    if(this.unos === false){
      this.unos = true;
      return;
    }
    if(this.unos === true){
      this.unos = false;
      return;
    }
  }
  showStavke(){
    this.cenovnikService.getStavke(this.selectedCenovnik).subscribe(
      data => {
        this.stavke = data;
        this.stavkeOut = data;
      }
    );
  }
  menjajStranicu(i) {
    this.selektovanaStranica = i;
    this.service.preuzmiCenovnike(i, this.brojStranica).subscribe(
      (data: any) => {
        this.cenovnici = data;
        this.iterator = Array(data.totalPages).fill(0).map((x, i) => i);
      }
    )      
   }

   menjaj() {
    this.selektovanaStranica = 0;
    this.service.preuzmiCenovnike(0,this.brojStranica).subscribe(
      (data:any) => {
        this.cenovnici = data;
        this.iterator = Array(data.totalPages).fill(0).map((x,i)=>i);
      }
    )
   }

}
