import { Pdv } from 'src/app/components/models/pdv';

export class GrupaProizvoda {

    constructor(

        public naziv: string,
        public opis: string,
        public pdv: Pdv,
        public id?: string

    ) {}
}
