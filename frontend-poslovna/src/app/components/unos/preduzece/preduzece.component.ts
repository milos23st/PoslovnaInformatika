import { Component, OnInit } from '@angular/core';
import { Preduzece } from '../../models/preduzece';
import { DataService } from '../../../data.service';

@Component({
  selector: 'app-preduzece',
  templateUrl: './preduzece.component.html',
  styleUrls: ['./preduzece.component.css']
})
export class PreduzeceComponent implements OnInit {
    
    preduzece = new Preduzece ('', '', '', '');

  constructor(
          private dataService: DataService
          ) { }

  ngOnInit() {
  }
  
  addPred() {
      this.dataService.addPreduzece(this.preduzece).subscribe(
    data => {
      console.log('uspesno')
    },
    error => {
      console.log('neuspesno')
    }
  );

}

}
