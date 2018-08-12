import { Preduzece } from './preduzece';
export class PoslovnaGodina {

    constructor(
        
        public godina: number,
        public zakljucena : boolean,
        public preduzece: Preduzece,
        public id?: string

    ){}
}