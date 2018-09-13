import { Component, OnInit } from '@angular/core';
import { DataService } from '../../../data.service';
import { GrupaProizvoda } from '../../models/grupa-proizvoda';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-grupa-p',
  templateUrl: './grupa-p.component.html',
  styleUrls: ['./grupa-p.component.css']
})
export class GrupaPComponent implements OnInit {

  dataSource = new GrupaDataSource(this.dataService);
  displayedColumns = ['naziv', 'opis', 'pdv'];

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

}

export class GrupaDataSource extends DataSource<any> {
  constructor(private dataService: DataService) {
    super();
  }
  connect(): Observable<GrupaProizvoda[]> {
    return this.dataService.getGrupeProizvoda();
  }
  disconnect() {}
}

