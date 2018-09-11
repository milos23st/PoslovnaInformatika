import {SelectionModel} from '@angular/cdk/collections';
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource, MatCheckboxModule } from '@angular/material';
import { Proizvod } from '../models/proizvod';
import { CenovnikService } from '../prikaz/cenovnik-p/cenovnik.service';
import { Preduzece } from '../models/preduzece';
import { GrupaProizvoda } from '../models/grupa-proizvoda';
import { JedinicaMere } from '../models/jedinica-mere';
import { FakturaService } from './faktura.service';
import { StavkaFakture } from '../models/stavka-fakture';
import { PoslovniPartner } from '../models/poslovni-partner';
import { Narudzbenica } from '../models/narudzbenica';

export interface StavkeData {
  proizvod: Proizvod;
  cena: string;
  stopaPDV: string;
  pdv: string;
  kolicina: string;
  id?: string;
}


@Component({
  selector: 'app-narudzbenica',
  styleUrls: ['narudzbenica.component.css'],
  templateUrl: 'narudzbenica.component.html',
})
export class NarudzbenicaComponent  implements OnInit  {
  displayedColumns: string[] = ['select','Proizvod', 'Grupa proizvoda', 'Jedinica Mere', 'Preduzece', 'Cena', 'Stopa PDV', 'PDV'];

  dataSource = new MatTableDataSource<StavkeData>();
  selection = new SelectionModel<StavkeData>(true, []);

  proizvodi: Proizvod[];
  stavke: StavkaFakture[];
  partneri: PoslovniPartner[];
  narudzbenica: Narudzbenica;
  stavkeOut: StavkaFakture[];
  unos = false;
  


  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  
  constructor(
    private cenovnikService: CenovnikService,
    private fakturaService: FakturaService,
  ) {
    this.narudzbenica = new Narudzbenica();
  }
  toggleUnos(){
    if(this.unos === false){
      this.unos = true;
      this.displayedColumns = ['select','Proizvod', 'Grupa proizvoda', 'Jedinica Mere', 'Preduzece', 'Cena', 'Stopa PDV', 'PDV',
       'Kolicina'];
      return;
    }
    if(this.unos === true){
      this.unos = false;
      this.displayedColumns = ['select','Proizvod', 'Grupa proizvoda', 'Jedinica Mere', 'Preduzece', 'Cena', 'Stopa PDV', 'PDV'];
      return;
    }
  }

    isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }



  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.fakturaService.getStavke().subscribe(
      data => {
        this.stavkeOut = data;
        this.stavke = data;
        this.narudzbenica.stavke = data;
        for(let i = 0; i < this.stavke.length; i++){
          let j = +this.stavke[i].cena * ((+this.stavke[i].stopaPDV) / 100);
          this.stavke[i].pdv = j.toString();
        }
        this.dataSource = new MatTableDataSource(this.stavke);
        this.dataSource.paginator = this.paginator;
      }
    );
    this.fakturaService.getPartneri().subscribe(
      data => {
        this.partneri = data;
      }
    )


  }
  naruci(){
    this.narudzbenica.stavke = this.stavkeOut;
    this.fakturaService.naruci(this.narudzbenica).subscribe();
    this.toggleUnos();
  }
   applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
/** Builds and returns a new User. */
/*function createNewUser(id: number): UserData {
  const name =
      NAMES[Math.round(Math.random() * (NAMES.length - 1))] + ' ' +
      NAMES[Math.round(Math.random() * (NAMES.length - 1))].charAt(0) + '.';

  return {
    id: id.toString(),
    name: name,
    progress: Math.round(Math.random() * 100).toString(),
    color: COLORS[Math.round(Math.random() * (COLORS.length - 1))]
  };
}*/




/**  Copyright 2018 Google Inc. All Rights Reserved.
    Use of this source code is governed by an MIT-style license that
    can be found in the LICENSE file at http://angular.io/license */