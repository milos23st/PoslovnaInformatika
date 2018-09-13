import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StavkaCenovnikaUnosComponent } from './stavka-cenovnika-unos.component';

describe('StavkaCenovnikaUnosComponent', () => {
  let component: StavkaCenovnikaUnosComponent;
  let fixture: ComponentFixture<StavkaCenovnikaUnosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StavkaCenovnikaUnosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StavkaCenovnikaUnosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
