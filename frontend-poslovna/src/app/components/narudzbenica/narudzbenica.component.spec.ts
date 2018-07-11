import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NarudzbenicaComponent } from './narudzbenica.component';

describe('NarudzbenicaComponent', () => {
  let component: NarudzbenicaComponent;
  let fixture: ComponentFixture<NarudzbenicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NarudzbenicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NarudzbenicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
