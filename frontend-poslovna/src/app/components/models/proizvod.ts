import { Preduzece } from './preduzece';
import { GrupaProizvoda } from './grupa-proizvoda';
import { JedinicaMere } from './jedinica-mere';
export class Proizvod {

    constructor(
        
        public nazivProizvoda: string,
        public opis: string,
        public preduzece: Preduzece,
        public grupaProizvod: GrupaProizvoda,
        public jedinicaMere: JedinicaMere,
        public id?: string

    ){}
}