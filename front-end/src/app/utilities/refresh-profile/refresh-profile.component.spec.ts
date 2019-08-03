import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RefreshProfileComponent } from './refresh-profile.component';

describe('RefreshProfileComponent', () => {
  let component: RefreshProfileComponent;
  let fixture: ComponentFixture<RefreshProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RefreshProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RefreshProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
