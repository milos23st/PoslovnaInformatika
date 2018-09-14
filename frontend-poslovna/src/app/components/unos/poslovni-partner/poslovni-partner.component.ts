import { Component, OnInit } from '@angular/core';
import { PoslovniPartner } from '../../models/poslovni-partner';
import { DataService } from '../../../data.service';
import { Preduzece } from '../../models/preduzece';

@Component({
  selector: 'app-poslovni-partner',
  templateUrl: './poslovni-partner.component.html',
  styleUrls: ['./poslovni-partner.component.css']
})
export class PoslovniPartnerComponent implements OnInit {

  poslovniPartner = new PoslovniPartner('', '', '', '', '', this.poslovniPartner);
  preduzeca: Preduzece[];
  broj: number;

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.dataService.getPreduzece().subscribe(
      (data: any) => {
        this.preduzeca = data;
      }
    )
  }

    addPoslovniP() {
      this.poslovniPartner.preduzece = this.preduzeca[this.broj];
        this.dataService.addPoslovniPart(this.poslovniPartner).subscribe(
      data => {
        console.log('uspesno')
      },
      error => {
        console.log('neuspesno')
      }
    );

  }


}
