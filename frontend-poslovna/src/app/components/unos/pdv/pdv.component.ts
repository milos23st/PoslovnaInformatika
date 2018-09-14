import { Component, OnInit } from '@angular/core';
import { DataService } from '../../../data.service';
import { Pdv } from '../../models/pdv';

@Component({
  selector: 'app-pdv',
  templateUrl: './pdv.component.html',
  styleUrls: ['./pdv.component.css']
})
export class PdvComponent implements OnInit {

  pdv = new Pdv('');

  constructor(private dataService: DataService) { }

  ngOnInit() {
  }

    addPdvv() {
        this.dataService.addPdv(this.pdv).subscribe(
      data => {
        console.log('uspesno')
      },
      error => {
        console.log('neuspesno')
      }
    );

  }

}
