import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PdvPComponent } from './pdv-p.component';

describe('PdvPComponent', () => {
  let component: PdvPComponent;
  let fixture: ComponentFixture<PdvPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PdvPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PdvPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
