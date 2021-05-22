import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterOverviewComponent } from './master-overview.component';

describe('MasterOverviewComponent', () => {
  let component: MasterOverviewComponent;
  let fixture: ComponentFixture<MasterOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MasterOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MasterOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
