import { Pipe, PipeTransform } from '@angular/core';
import { Proizvod } from '../../models/proizvod';
import { StavkaCenovnika } from '../../models/stavkacenovnika';
@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(stavke: StavkaCenovnika[], searchText: string): any {
    return stavke.filter(stavka => stavka.proizvod.nazivProizvoda.toLowerCase().indexOf(searchText.toLowerCase()) !== -1);
  }

}
