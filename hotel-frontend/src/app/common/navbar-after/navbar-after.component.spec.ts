import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarAfterComponent } from './navbar-after.component';

describe('NavbarAfterComponent', () => {
  let component: NavbarAfterComponent;
  let fixture: ComponentFixture<NavbarAfterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarAfterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarAfterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
