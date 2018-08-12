import { Component, OnInit } from '@angular/core';
import { DataService } from './../../../data.service';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';
import { Preduzece } from './../../models/preduzece';

@Component({
  selector: 'app-preduzece-p',
  templateUrl: './preduzece-p.component.html',
  styleUrls: ['./preduzece-p.component.css']
})
export class PreduzecePComponent implements OnInit {
    
    dataSource = new PreduzeceDataSource(this.dataService);
    displayedColumns = ['nazivPreduzeca','pib','email','adresa'];


  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

}

export class PreduzeceDataSource extends DataSource<any> {
    constructor(private dataService: DataService) {
        super();
      }
    connect(): Observable<Preduzece[]> {
        return this.dataService.getPreduzece();
    }
    disconnect() {}
}
