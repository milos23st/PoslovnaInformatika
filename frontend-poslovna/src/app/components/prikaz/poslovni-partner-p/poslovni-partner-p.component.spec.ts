import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PoslovniPartnerPComponent } from './poslovni-partner-p.component';

describe('PoslovniPartnerPComponent', () => {
  let component: PoslovniPartnerPComponent;
  let fixture: ComponentFixture<PoslovniPartnerPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PoslovniPartnerPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PoslovniPartnerPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
