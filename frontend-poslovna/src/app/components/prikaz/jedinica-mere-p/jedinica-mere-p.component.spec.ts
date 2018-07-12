import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JedinicaMerePComponent } from './jedinica-mere-p.component';

describe('JedinicaMerePComponent', () => {
  let component: JedinicaMerePComponent;
  let fixture: ComponentFixture<JedinicaMerePComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JedinicaMerePComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JedinicaMerePComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
