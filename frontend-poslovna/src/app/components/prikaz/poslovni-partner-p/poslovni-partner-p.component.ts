import { Component, OnInit } from '@angular/core';
import { DataService } from '../../../data.service';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs';
import { PoslovniPartner } from '../../models/poslovni-partner';

@Component({
  selector: 'app-poslovni-partner-p',
  templateUrl: './poslovni-partner-p.component.html',
  styleUrls: ['./poslovni-partner-p.component.css']
})
export class PoslovniPartnerPComponent implements OnInit {

  dataSource = new PoslovniDataSource(this.dataService);
  displayedColumns = ['naziv', 'adresa', 'brojTelefona', 'email', 'brojRacuna', 'preduzece'];


  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

}


export class PoslovniDataSource extends DataSource<any> {
  constructor(private dataService: DataService) {
    super();
  }
  connect(): Observable<PoslovniPartner[]> {
    return this.dataService.getPoslovniPartneri();
  }
  disconnect() {}
}

