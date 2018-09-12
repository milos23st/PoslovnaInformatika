export class Faktura {
        brojFakture: string;
        datumFakture: string;
        datumValute: string;
        ukupanRabat: string;
        bezPDV: string;
        ukupanPorez: string;
        iznosFakture: string;
        id?: string;

    constructor(
        brojFakture: string,
        datumFakture: string,
        datumValute: string,
        ukupanRabat: string,
        bezPDV: string,
        ukupanPorez: string,
        iznosFakture: string,
        id?: string
    ){
        this.brojFakture = brojFakture;
        this.datumFakture = datumFakture;
        this.datumValute = datumValute;
        this.ukupanRabat = ukupanRabat;
        this.bezPDV = bezPDV;
        this.ukupanPorez = ukupanPorez;
         this.iznosFakture = iznosFakture;
         this.id = id;


    }
}
