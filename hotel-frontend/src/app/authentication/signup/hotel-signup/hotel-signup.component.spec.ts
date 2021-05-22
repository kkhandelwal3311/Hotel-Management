import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelSignupComponent } from './hotel-signup.component';

describe('HotelSignupComponent', () => {
  let component: HotelSignupComponent;
  let fixture: ComponentFixture<HotelSignupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HotelSignupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HotelSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
