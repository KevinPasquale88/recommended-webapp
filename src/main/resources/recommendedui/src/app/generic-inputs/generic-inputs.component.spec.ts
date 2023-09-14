import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenericInputsComponent } from './generic-inputs.component';

describe('GenericInputsComponent', () => {
  let component: GenericInputsComponent;
  let fixture: ComponentFixture<GenericInputsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenericInputsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GenericInputsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
