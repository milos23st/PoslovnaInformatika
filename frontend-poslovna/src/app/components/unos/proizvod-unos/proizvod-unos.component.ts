import { Component, OnInit } from '@angular/core';
import { Proizvod } from '../../models/proizvod';
import { Preduzece } from '../../models/preduzece';
import { JedinicaMere } from '../../models/jedinica-mere';
import { GrupaProizvoda } from '../../models/grupa-proizvoda';
import { DataService } from '../../../data.service';
import { FakturaService } from '../../narudzbenica/faktura.service';

@Component({
  selector: 'app-proizvod-unos',
  templateUrl: './proizvod-unos.component.html',
  styleUrls: ['./proizvod-unos.component.css']
})
export class ProizvodUnosComponent implements OnInit {
  proizvod: Proizvod;
  preduzeca: Preduzece[];
  grupe: GrupaProizvoda[];
  jedinice: JedinicaMere[];
  grupeI: number;
  jediniceI: number;
  preduzecaI: number;
  constructor(
    private service: DataService,
    private fService: FakturaService
  ) { }

  ngOnInit() {
    this.proizvod = new Proizvod(null,null,null,null,null);
    this.service.getJedMere().subscribe(
      data => {
        this.jedinice = data;
      }
    );
    this.service.getGrupeProizvoda().subscribe(
      data => {
        this.grupe = data;
      }
    );
    this.service.getPreduzece().subscribe(
      data => {
        this.preduzeca = data;
      }
    )
  }
  addProizvod(){
    this.proizvod.preduzece = this.preduzeca[this.preduzecaI];
    this.proizvod.grupaProizvod = this.grupe[this.grupeI];
    this.proizvod.jedinicaMere = this.jedinice[this.jediniceI];
    this.fService.addProizvod(this.proizvod).subscribe();

  }

}
