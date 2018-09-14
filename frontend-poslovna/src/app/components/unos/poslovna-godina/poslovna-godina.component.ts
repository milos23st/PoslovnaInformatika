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
  poslovnaGodina: PoslovnaGodina;
  checked: boolean;

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.poslovnaGodina = new PoslovnaGodina(null, null, null);
    this.checked = false;
    this.dataService.getPreduzece().subscribe(
      (data: any) => {
        this.preduzeca = data;
      }
    );
  }
  addPoslovnaGodina(){
    this.poslovnaGodina.preduzece = this.preduzeca[this.broj];
    /*if(this.checked === true){
      this.poslovnaGodina.zakljucena = true;
    }*/
    this.poslovnaGodina.zakljucena = this.checked;
    this.dataService.addPoslovnaGodina(this.poslovnaGodina).subscribe(
      data => {
        this.checked = false;
      }
    );
  }

}
