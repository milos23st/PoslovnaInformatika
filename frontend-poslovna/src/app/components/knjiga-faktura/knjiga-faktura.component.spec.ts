import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KnjigaFakturaComponent } from './knjiga-faktura.component';

describe('KnjigaFakturaComponent', () => {
  let component: KnjigaFakturaComponent;
  let fixture: ComponentFixture<KnjigaFakturaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KnjigaFakturaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KnjigaFakturaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
