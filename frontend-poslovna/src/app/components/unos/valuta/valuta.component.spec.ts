import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValutaComponent } from './valuta.component';

describe('ValutaComponent', () => {
  let component: ValutaComponent;
  let fixture: ComponentFixture<ValutaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValutaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
