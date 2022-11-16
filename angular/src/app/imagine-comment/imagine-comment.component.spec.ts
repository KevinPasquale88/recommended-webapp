import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImagineCommentComponent } from './imagine-comment.component';

describe('ImagineCommentComponent', () => {
  let component: ImagineCommentComponent;
  let fixture: ComponentFixture<ImagineCommentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImagineCommentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImagineCommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
