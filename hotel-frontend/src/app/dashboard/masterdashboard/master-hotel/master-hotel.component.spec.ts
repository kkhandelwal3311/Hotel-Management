import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterHotelComponent } from './master-hotel.component';

describe('MasterHotelComponent', () => {
  let component: MasterHotelComponent;
  let fixture: ComponentFixture<MasterHotelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MasterHotelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MasterHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
