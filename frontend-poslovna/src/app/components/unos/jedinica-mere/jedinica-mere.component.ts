
import { Component, OnInit } from '@angular/core';
import { JedinicaMere } from '../../models/jedinica-mere';
import { DataService } from '../../../data.service';

@Component({
  selector: 'app-jedinica-mere',
  templateUrl: './jedinica-mere.component.html',
  styleUrls: ['./jedinica-mere.component.css']
})
export class JedinicaMereComponent implements OnInit {

  jedinicaMere = new JedinicaMere('', '');

  constructor(
    private dataService: DataService
  ) { }

  ngOnInit() {
  }

addJM() {
        this.dataService.addJedMere(this.jedinicaMere).subscribe(
      data => {
        console.log('uspesno')
      },
      error => {
        console.log('neuspesno')
      }
    );

  }

}
