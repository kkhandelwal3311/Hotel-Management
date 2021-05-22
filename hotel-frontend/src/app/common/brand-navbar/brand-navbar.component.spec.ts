import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrandNavbarComponent } from './brand-navbar.component';

describe('BrandNavbarComponent', () => {
  let component: BrandNavbarComponent;
  let fixture: ComponentFixture<BrandNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrandNavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrandNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
