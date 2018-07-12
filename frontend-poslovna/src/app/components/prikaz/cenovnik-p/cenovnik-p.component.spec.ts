import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CenovnikPComponent } from './cenovnik-p.component';

describe('CenovnikPComponent', () => {
  let component: CenovnikPComponent;
  let fixture: ComponentFixture<CenovnikPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CenovnikPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CenovnikPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
