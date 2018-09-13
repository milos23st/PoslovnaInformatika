import { Component, OnInit } from '@angular/core';
import { FakturaService } from '../narudzbenica/faktura.service';

@Component({
  selector: 'app-knjiga-faktura',
  templateUrl: './knjiga-faktura.component.html',
  styleUrls: ['./knjiga-faktura.component.css']
})
export class KnjigaFakturaComponent implements OnInit {
  fromDate: string;
  toDate: string;
  constructor(
    private fakturaService: FakturaService
  ) { }

  ngOnInit() {
  }

  getKif(): string{
    let s = 'http://localhost:1234/api/izvestaj/KIF/' + Date.parse(this.fromDate) + '/' + Date.parse(this.toDate);
    return s;
  }

}
