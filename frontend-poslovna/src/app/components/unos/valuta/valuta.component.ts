import { Component, OnInit } from '@angular/core';
import { Valuta } from '../../models/Valuta';
import { DataService } from '../../../data.service';

@Component({
  selector: 'app-valuta',
  templateUrl: './valuta.component.html',
  styleUrls: ['./valuta.component.css']
})
export class ValutaComponent implements OnInit {

  valuta = new Valuta('', '');

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

  addVal() {
        this.dataService.addValute(this.valuta).subscribe(
      data => {
        console.log('uspesno')
      },
      error => {
        console.log('neuspesno')
      }
    );

  }


}
