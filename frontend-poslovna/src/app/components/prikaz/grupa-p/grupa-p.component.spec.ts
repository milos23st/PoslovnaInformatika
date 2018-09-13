import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupaPComponent } from './grupa-p.component';

describe('GrupaPComponent', () => {
  let component: GrupaPComponent;
  let fixture: ComponentFixture<GrupaPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupaPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupaPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
