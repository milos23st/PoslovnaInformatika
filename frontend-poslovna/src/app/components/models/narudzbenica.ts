import { StavkaFakture } from './stavka-fakture';

export class Narudzbenica {
    stavke: StavkaFakture[];
    idPoslovnogPartnera: string;
    constructor(
        stavke?: StavkaFakture[]
    ) {

    }
}
