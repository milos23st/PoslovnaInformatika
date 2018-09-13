import { Proizvod } from './proizvod';

export class StavkaCenovnika {
  procenat: number;
  proizvod: Proizvod;
  cena: number;
  id: number;
  constructor(
      cena: number,
      proizvod: Proizvod,
      procenat1: number,
      id?: number
  ) {
    this.procenat = procenat1;
    this.proizvod = proizvod;
    this.cena = cena;
    this.id = id;
}
}