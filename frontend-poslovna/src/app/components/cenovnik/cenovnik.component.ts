import { Component, OnInit } from '@angular/core';
import { Cenovnik } from '../models/cenovnik';
import { FakturaService } from '../narudzbenica/faktura.service';



@Component({
  selector: 'app-cenovnik',
  templateUrl: './cenovnik.component.html',
  styleUrls: ['./cenovnik.component.css']
})
export class CenovnikComponent implements OnInit {
  cenovnik: Cenovnik;
  datum: any;
  e: number[];
  constructor(
    private service: FakturaService
  ) { }

  ngOnInit() {
    this.cenovnik = new Cenovnik(new Date(),null,null,null);
  }
  addCenovnik(){
    
    this.e = this.datum.split('-');
    const d = new Date(Date.UTC(this.e[0], this.e[1] - 1, this.e[2]));

    this.cenovnik.datumVazenja.setFullYear(d.getUTCFullYear(), d.getUTCMonth(), d.getUTCDate());
    this.service.addCenovnik(this.cenovnik).subscribe();
  }
}
