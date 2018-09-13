export class Cenovnik {
    datumVazenja: Date;
    constructor(

        public datumVazenja1: Date,
        public valuta: string,
        public preduzece,
        public id?: string


    ) {
        this.datumVazenja = datumVazenja1;
    }
}
