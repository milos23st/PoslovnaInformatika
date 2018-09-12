import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Pdv } from '../../models/pdv';
import { DataService } from '../../../data.service';
import { DataSource } from '@angular/cdk/table';

@Component({
  selector: 'app-pdv-p',
  templateUrl: './pdv-p.component.html',
  styleUrls: ['./pdv-p.component.css']
})
export class PdvPComponent implements OnInit {

  dataSource = new PdvDataSource(this.dataService);
  displayedColumns = ['naziv'];


  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

}

export class PdvDataSource extends DataSource<any> {

  constructor(private dataService: DataService) {
    super();
  }

  connect(): Observable<Pdv[]> {
    return this.dataService.getPdv();
  }
  disconnect() {}
}
