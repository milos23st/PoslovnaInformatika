import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValutaPComponent } from './valuta-p.component';

describe('ValutaPComponent', () => {
  let component: ValutaPComponent;
  let fixture: ComponentFixture<ValutaPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValutaPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValutaPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
