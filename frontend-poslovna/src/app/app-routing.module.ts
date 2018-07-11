import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { CenovnikComponent } from './components/cenovnik/cenovnik.component';
import { NarudzbenicaComponent } from './components/narudzbenica/narudzbenica.component';
import { CenovniciComponent } from './components/glavno/cenovnici/cenovnici.component';
import { ProizvodiComponent } from './components/glavno/proizvodi/proizvodi.component';
import { FaktureComponent } from './components/glavno/fakture/fakture.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'cenovnik', component: CenovnikComponent},
  { path: 'narudzbenica', component: NarudzbenicaComponent},
  { path: 'cenovnici', component: CenovniciComponent},
  { path: 'proizvodi', component: ProizvodiComponent},
  { path: 'fakture', component: FaktureComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
