import { BrowserModule } from '@angular/platform-browser';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MaterialModule} from './components/narudzbenica/material.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import 'hammerjs';
import { SelectionModel } from '@angular/cdk/collections';

import {  MATERIAL_SANITY_CHECKS } from '@angular/material';
import { MatProgressSpinnerModule } from '@angular/material';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { NarudzbenicaComponent } from './components/narudzbenica/narudzbenica.component';
import { CenovnikComponent } from './components/cenovnik/cenovnik.component';
import { HomeComponent } from './components/home/home.component';


import {CdkTableModule} from '@angular/cdk/table';
import {CdkTreeModule} from '@angular/cdk/tree';
import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {
  MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
 // MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
} from '@angular/material';
import { Pipe, PipeTransform } from '@angular/core';
import { SearchPipe } from './components/prikaz/cenovnik-p/search.pipe';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import { CenovniciComponent } from './components/glavno/cenovnici/cenovnici.component';
import { ProizvodiComponent } from './components/glavno/proizvodi/proizvodi.component';
import { FaktureComponent } from './components/glavno/fakture/fakture.component';
import { DataService } from './data.service';
import { CenovnikPComponent } from './components/prikaz/cenovnik-p/cenovnik-p.component';
import { JedinicaMereComponent } from './components/unos/jedinica-mere/jedinica-mere.component';
import { PdvComponent } from './components/unos/pdv/pdv.component';
import { ValutaComponent } from './components/unos/valuta/valuta.component';
import { GrupaProizvodaComponent } from './components/unos/grupa-proizvoda/grupa-proizvoda.component';
import { PoslovnaGodinaComponent } from './components/unos/poslovna-godina/poslovna-godina.component';
import { PreduzeceComponent } from './components/unos/preduzece/preduzece.component';
import { JedinicaMerePComponent } from './components/prikaz/jedinica-mere-p/jedinica-mere-p.component';
import { PreduzecePComponent } from './components/prikaz/preduzece-p/preduzece-p.component';
import { ValutaPComponent } from './components/prikaz/valuta-p/valuta-p.component';
import { PdvPComponent } from './components/prikaz/pdv-p/pdv-p.component';



@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    NarudzbenicaComponent,
    CenovnikComponent,
    HomeComponent,
    CenovniciComponent,
    ProizvodiComponent,
    FaktureComponent,
    CenovnikPComponent,
    JedinicaMereComponent,
    PdvComponent,
    ValutaComponent,
    GrupaProizvodaComponent,
    PoslovnaGodinaComponent,
    PreduzeceComponent,
    JedinicaMerePComponent,
    PreduzecePComponent,
    SearchPipe,
    ValutaPComponent,
    PdvPComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    MatCheckboxModule,
    MatProgressSpinnerModule,

    MatSelectModule,

    MatTableModule,

    MatDatepickerModule,


    MatNativeDateModule,
    ReactiveFormsModule,

    NgbModule.forRoot()

  ],

  exports: [
    CdkTableModule,
    CdkTreeModule,
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
  ],

  providers: [

    DataService,

     {
            provide: MATERIAL_SANITY_CHECKS,
            useValue: false
            }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
