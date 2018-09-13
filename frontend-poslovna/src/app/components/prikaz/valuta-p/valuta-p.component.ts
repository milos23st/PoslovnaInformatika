import { Component, OnInit } from '@angular/core';
import { DataService } from './../../../data.service';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs';
import { Valuta } from '../../models/Valuta';

@Component({
  selector: 'app-valuta-p',
  templateUrl: './valuta-p.component.html',
  styleUrls: ['./valuta-p.component.css']
})
export class ValutaPComponent implements OnInit {

  dataSource = new ValutaDataSource(this.dataService);

  displayedColumns = ['naziv', 'oznaka'];


  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

}

export class ValutaDataSource extends DataSource<any> {
  constructor(private dataService: DataService) {
    super();
  }

  connect(): Observable<Valuta[]> {
    return this.dataService.getValute();
  }
  disconnect() {}
}
