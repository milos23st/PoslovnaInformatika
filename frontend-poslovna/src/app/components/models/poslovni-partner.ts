import { Preduzece } from './preduzece';
export class PoslovniPartner {

    constructor(
    
        
        public naziv: string,
        public adresa: string,
        public brojTelefona: string,
        public email: string,
        public brojRacuna: string,
        public preduzece: Preduzece,
        public vrsta?: string,
        public id?: string

    ){}
}