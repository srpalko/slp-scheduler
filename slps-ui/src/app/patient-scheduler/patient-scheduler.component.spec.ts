import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientSchedulerComponent } from './patient-scheduler.component';

describe('PatientSchedulerComponent', () => {
  let component: PatientSchedulerComponent;
  let fixture: ComponentFixture<PatientSchedulerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientSchedulerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientSchedulerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
