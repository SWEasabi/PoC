import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LampButtonComponent } from './lamp-button.component';

describe('LampButtonComponent', () => {
  let component: LampButtonComponent;
  let fixture: ComponentFixture<LampButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LampButtonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LampButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
