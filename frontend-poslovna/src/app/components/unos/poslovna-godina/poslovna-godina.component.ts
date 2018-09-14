import { Component, OnInit } from '@angular/core';
import { DataService } from '../../../data.service';
import { Preduzece } from '../../models/preduzece';
import { PoslovnaGodina } from '../../models/poslovna-godina';

@Component({
  selector: 'app-poslovna-godina',
  templateUrl: './poslovna-godina.component.html',
  styleUrls: ['./poslovna-godina.component.css']
})
export class PoslovnaGodinaComponent implements OnInit {
/*
poslovnaGodina = new PoslovnaGodina('', '', '');
*/
  preduzeca: Preduzece[];
  broj: number;

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.dataService.getPreduzece().subscribe(
      (data: any) => {
        this.preduzeca = data;
      }
    );
  }

}
