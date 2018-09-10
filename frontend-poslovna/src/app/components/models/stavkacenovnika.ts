import { Proizvod } from './proizvod';

export class StavkaCenovnika {
  procenat: number;
  proizvod: Proizvod;
  constructor(
      cena: number,
      proizvod: Proizvod,
      procenat1: number,
      id?: string
  ) {
    this.procenat = procenat1;
    this.proizvod = proizvod;
}
}