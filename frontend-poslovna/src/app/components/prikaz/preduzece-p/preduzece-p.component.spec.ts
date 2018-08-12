import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreduzecePComponent } from './preduzece-p.component';

describe('PreduzecePComponent', () => {
  let component: PreduzecePComponent;
  let fixture: ComponentFixture<PreduzecePComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreduzecePComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreduzecePComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
