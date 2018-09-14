import { Preduzece } from './preduzece';
export class PoslovniPartner {
    public vrsta: string;
    constructor(
    
        
        public naziv: string,
        public adresa: string,
        public brojTelefona: string,
        public email: string,
        public brojRacuna: string,
        public preduzece: Preduzece,
        public vrsta1?: string,
        public id?: string

    ){
        this.vrsta = vrsta1;
    }
}