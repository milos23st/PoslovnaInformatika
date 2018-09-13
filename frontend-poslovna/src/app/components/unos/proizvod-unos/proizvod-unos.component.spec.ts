import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProizvodUnosComponent } from './proizvod-unos.component';

describe('ProizvodUnosComponent', () => {
  let component: ProizvodUnosComponent;
  let fixture: ComponentFixture<ProizvodUnosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProizvodUnosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProizvodUnosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
