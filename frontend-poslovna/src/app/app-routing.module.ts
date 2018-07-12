import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { CenovnikComponent } from './components/cenovnik/cenovnik.component';
import { NarudzbenicaComponent } from './components/narudzbenica/narudzbenica.component';
import { CenovniciComponent } from './components/glavno/cenovnici/cenovnici.component';
import { ProizvodiComponent } from './components/glavno/proizvodi/proizvodi.component';
import { FaktureComponent } from './components/glavno/fakture/fakture.component';
import { CenovnikPComponent } from './components/prikaz/cenovnik-p/cenovnik-p.component';
import { JedinicaMereComponent } from './components/unos/jedinica-mere/jedinica-mere.component'; 
import { PdvComponent } from './components/unos/pdv/pdv.component';
import { GrupaProizvodaComponent } from './components/unos/grupa-proizvoda/grupa-proizvoda.component';
import { PoslovnaGodinaComponent } from './components/unos/poslovna-godina/poslovna-godina.component';
import { PreduzeceComponent } from './components/unos/preduzece/preduzece.component';
import { ValutaComponent } from './components/unos/valuta/valuta.component';
import { JedinicaMerePComponent } from './components/prikaz/jedinica-mere-p/jedinica-mere-p.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'cenovnik', component: CenovnikComponent},
  { path: 'narudzbenica', component: NarudzbenicaComponent},
  { path: 'cenovnici', component: CenovniciComponent},
  { path: 'proizvodi', component: ProizvodiComponent},
  { path: 'fakture', component: FaktureComponent},



// prikaz
  { path: 'cenovnik1', component: CenovnikPComponent},
  { path: 'jedinicaMere1', component: JedinicaMerePComponent},
  

//unos
  { path: 'jedinicaMere', component: JedinicaMereComponent},
  { path: 'pdv', component : PdvComponent },
  { path: 'grupaProizvoda', component : GrupaProizvodaComponent },
  { path: 'poslovnaGodina', component : PoslovnaGodinaComponent },
  { path: 'preduzece', component : PreduzeceComponent },
  { path: 'valuta', component : ValutaComponent },
  


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
