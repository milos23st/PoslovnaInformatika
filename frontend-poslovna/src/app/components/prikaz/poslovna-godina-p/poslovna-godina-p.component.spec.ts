import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PoslovnaGodinaPComponent } from './poslovna-godina-p.component';

describe('PoslovnaGodinaPComponent', () => {
  let component: PoslovnaGodinaPComponent;
  let fixture: ComponentFixture<PoslovnaGodinaPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PoslovnaGodinaPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PoslovnaGodinaPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
