import { Component, OnInit } from '@angular/core';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-hotel-dashboard',
  templateUrl: './hotel-dashboard.component.html',
  styleUrls: ['./hotel-dashboard.component.css'],
})
export class HotelDashboardComponent implements OnInit {
  sideNavOpened = true;
  hotel: any;
  allHotelData: any = [];
  constructor(
    private hotelService: HotelService,
    private signinService: SigninService
  ) {}

  ngOnInit(): void {
    // get hotel data
    this.hotel = this.signinService.getHotelLoginData();
  }

  closeSideNav() {
    this.sideNavOpened = !this.sideNavOpened;
  }

  logoutHotel() {
    this.signinService.logoutHotel();
  }
}
