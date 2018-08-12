import { Preduzece } from './preduzece';
export class PoslovniPartner {

    constructor(
    
        public vrsta: string,
        public naziv: string,
        public adresa: string,
        public brojTelefona: string,
        public email: string,
        public brojRacuna: string,
        public preduzece: Preduzece,
        public id?: string

    ){}
}