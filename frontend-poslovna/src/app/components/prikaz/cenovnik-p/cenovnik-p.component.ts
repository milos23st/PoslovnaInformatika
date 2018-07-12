import { Component, OnInit } from '@angular/core';
import { DataService } from './../../../data.service';

@Component({
  selector: 'app-cenovnik-p',
  templateUrl: './cenovnik-p.component.html',
  styleUrls: ['./cenovnik-p.component.css'],
  providers: [ DataService ]
})
export class CenovnikPComponent implements OnInit {

  
  cenovnici:any = [];
  iterator;
  selektovanaStranica:number;
  brojStranica = 5;

  constructor(private service : DataService) { }

  ngOnInit() {
    this.selektovanaStranica = 0;
    this.service.preuzmiCenovnike(0,this.brojStranica).subscribe(
      (data:any) => {
        this.cenovnici = data;
        this.iterator = Array(data.totalPages).fill(0).map((x,i)=>i);
      }
    )
  }

  menjajStranicu(i) { 
    this.selektovanaStranica = i;
    this.service.preuzmiCenovnike(i,this.brojStranica).subscribe(
      (data:any) => {
        this.cenovnici = data;
        this.iterator = Array(data.totalPages).fill(0).map((x,i)=>i); 
      }
    )      
   }

   menjaj() {
    this.selektovanaStranica = 0;
    this.service.preuzmiCenovnike(0,this.brojStranica).subscribe(
      (data:any) => {
        this.cenovnici = data;
        this.iterator = Array(data.totalPages).fill(0).map((x,i)=>i);
      }
    )
   }

}
