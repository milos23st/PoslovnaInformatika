import { Component, OnInit, ViewChild } from '@angular/core';
import { FakturaService } from '../../narudzbenica/faktura.service';
import {SelectionModel} from '@angular/cdk/collections';
import {MatPaginator, MatSort, MatTableDataSource, MatCheckboxModule } from '@angular/material';
import { Preduzece } from '../../models/preduzece';
import { GrupaProizvoda } from '../../models/grupa-proizvoda';
import { JedinicaMere } from '../../models/jedinica-mere';
import { Proizvod } from '../../models/proizvod';

export interface ProizvodData {
 nazivProizvoda: string;
 opis: string;
 preduzece: Preduzece;
 grupaProizvod: GrupaProizvoda;
 jedinicaMere: JedinicaMere;
 id?: string;
}
@Component({
  selector: 'app-proizvod',
  templateUrl: './proizvod.component.html',
  styleUrls: ['./proizvod.component.css']
})
export class ProizvodComponent implements OnInit {
  displayedColumns: string[] = ['select', 'naziv', 'opis', 'preduzece', 'grupa', 'jedinica'];

  dataSource = new MatTableDataSource<ProizvodData>();
  selection = new SelectionModel<ProizvodData>(true, []);
  proizvodi: Proizvod[];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(
    private service: FakturaService
  ) { }

  ngOnInit() {
    this.service.getProizvodi().subscribe(
      data => {
        this.proizvodi = data;
        this.dataSource = new MatTableDataSource(this.proizvodi);
        this.dataSource.paginator = this.paginator;
      }
    )
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

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
