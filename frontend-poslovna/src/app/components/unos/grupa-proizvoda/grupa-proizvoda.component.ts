import { Component, OnInit } from '@angular/core';
import { DataService } from '../../../data.service';
import { Pdv } from './../../models/pdv';
import { GrupaProizvoda } from '../../models/grupa-proizvoda';

@Component({
  selector: 'app-grupa-proizvoda',
  templateUrl: './grupa-proizvoda.component.html',
  styleUrls: ['./grupa-proizvoda.component.css']
})
export class GrupaProizvodaComponent implements OnInit {

  grupaProizvoda = new GrupaProizvoda('', '', this.grupaProizvoda);
  pdvI: Pdv[];
  broj: number;

  constructor(
    private dataService: DataService
  ) { }

  ngOnInit() {

       this.dataService.getPdv().subscribe(
      (data: any) => {
        this.pdvI = data;
      }
    );


  }

  addGrupaProizvoda() {
    this.grupaProizvoda.pdv = this.pdvI[this.broj];
    this.dataService.addGrupaProizvoda(this.grupaProizvoda).subscribe(
      data => {
        console.log('uspesno')
      },
      error => {
        console.log('neuspesno')
      }
    );
  }

}
