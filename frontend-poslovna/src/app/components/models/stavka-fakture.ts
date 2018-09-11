import { Proizvod } from './proizvod';
export class StavkaFakture {
    proizvod: Proizvod;
    cena: string;
    stopaPDV: string;
    pdv: string;
    kolicina: string;
    id?: string;
    constructor(
        proizvod: Proizvod,
	    cena: string,
        stopaPDV: string,
        pdv: string,
        kolicina: string,
        id?: string
    ) {
        this.proizvod = proizvod;
        this.cena = cena;
        this.stopaPDV = stopaPDV;
        this.pdv = pdv;
        this.id = id;
    }
}
