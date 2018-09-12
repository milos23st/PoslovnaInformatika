import { Component, OnInit, ViewChild  } from '@angular/core';
import {SelectionModel} from '@angular/cdk/collections';
import {MatPaginator, MatSort, MatTableDataSource, MatCheckboxModule } from '@angular/material';
import { FakturaService } from '../../narudzbenica/faktura.service';
import { PoslovnaGodina } from '../../models/poslovna-godina';
import { Faktura } from '../../models/faktura';
import { Izvestaj } from '../../models/izvestaj';
import { DomSanitizer, SafeUrl, SafeResourceUrl } from '@angular/platform-browser';

export interface FaktureData {
  brojFakture: string;
  datumFakture: string;
  datumValute: string;
  ukupanRabat: string;
  bezPDV: string;
  ukupanPorez: string;
  iznosFakture: string;
  id?: string;
}

@Component({
  selector: 'app-fakture',
  templateUrl: './fakture.component.html',
  styleUrls: ['./fakture.component.css']
})
export class FaktureComponent implements OnInit {
  displayedColumns: string[] = ['select','brojFakture', 'datumFakture', 'datumValute','ukupanRabat', 'bezPDV', 'ukupanPorez',
   'iznosFakture', 'dugmici'];
  dataSource = new MatTableDataSource<FaktureData>();
  selection = new SelectionModel<FaktureData>(true, []);
  godine: PoslovnaGodina[];
  godina: number;
  fakture: Faktura[];
  unos = false;
  izvestaj: Izvestaj;
  dangerousUrl: string;
  trustedUrl: SafeResourceUrl;
  preuzeo = false;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private fakturaService: FakturaService,
    private sanitizer: DomSanitizer
  ) {
    this.dangerousUrl = 'data:application/pdf;base64';
    this.trustedUrl = sanitizer.bypassSecurityTrustUrl(this.dangerousUrl);

   }

  ngOnInit() {
    
    this.fakturaService.getPoslovneGodine().subscribe(
      data => {
        this.godine = data;
        this.fakturaService.getFaktureIzGodine(+this.godine[0].id).subscribe(
          data1 => {
            this.fakture = data1;
            this.dataSource = new MatTableDataSource(this.fakture);
            this.dataSource.paginator = this.paginator;
          }
        );
      }
    );
  }
  getHtml(html){
    this.trustedUrl = this.sanitizer.bypassSecurityTrustResourceUrl(html + ',' + this.izvestaj.report);
    return this.sanitizer.bypassSecurityTrustHtml(html);
}
  getIzvestaj(id: number): string{
    /*this.fakturaService.getIzvestaj(+this.fakture[id].id).subscribe(
      data => {
        this.izvestaj = data;
        this.preuzeo = true;
      }
    )*/
    let s = 'http://localhost:1234/api/izvestaj/FSS/' + this.fakture[id].id;
    return s;
  }
  changeGodina(){
    this.fakturaService.getFaktureIzGodine(this.godina).subscribe(
      data => {
        this.fakture = data;
        this.dataSource = new MatTableDataSource(this.fakture);
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
