import { Component, OnInit, Input } from '@angular/core';
import { JedinicaMere } from './../../models/jedinica-mere';
import { DataService } from './../../../data.service';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';


@Component({
  selector: 'app-jedinica-mere-p',
  templateUrl: './jedinica-mere-p.component.html',
  styleUrls: ['./jedinica-mere-p.component.css']
})
export class JedinicaMerePComponent implements OnInit {
/*
  @Input() prikazJedinicaMere : JedinicaMere;

  jediniceMere: JedinicaMere[];
  jedinicaMereId: string;
  jedinicaMereEdit: JedinicaMere;


  getJedMere(): void {
    this.dataService.getJedMere()
      .subscribe(jediniceMere => this.jediniceMere = jediniceMere);
  }
*/

  dataSource = new JedinicaMereDataSource(this.dataService);
  displayedColumns = ['naziv', 'skracenica'];

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

}

export class JedinicaMereDataSource extends DataSource<any> {
  constructor(private dataService: DataService) {
    super();
  }

  connect(): Observable<JedinicaMere[]> {
    return this.dataService.getJedMere();

  }
  disconnect() {}
}
