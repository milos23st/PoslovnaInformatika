import { Component, OnInit } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs';
import { DataService } from '../../../data.service';
import { PoslovnaGodina } from '../../models/poslovna-godina';

@Component({
  selector: 'app-poslovna-godina-p',
  templateUrl: './poslovna-godina-p.component.html',
  styleUrls: ['./poslovna-godina-p.component.css']
})
export class PoslovnaGodinaPComponent implements OnInit {

  dataSource = new PoslovnaGodinaDataSource(this.dataService);
  displayedColumns = ['godina', 'zakljucena', 'preduzece'];

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

}

export class PoslovnaGodinaDataSource extends DataSource<any> {
  constructor(private dataService: DataService) {
    super();
  }
  connect(): Observable<PoslovnaGodina[]> {
    return this.dataService.getPoslovneGodine();
  }
  disconnect() {}
}

