import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlterQuestionComponent } from './alter-question.component';

describe('AlterQuestionComponent', () => {
  let component: AlterQuestionComponent;
  let fixture: ComponentFixture<AlterQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlterQuestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlterQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
