import { Component, OnInit } from '@angular/core';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../home/hotel.service';

@Component({
  selector: 'app-user-booking',
  templateUrl: './user-booking.component.html',
  styleUrls: ['./user-booking.component.css'],
})
export class UserBookingComponent implements OnInit {
  loggedInUser: any;
  bookingData: any = [];

  constructor(
    private hotelService: HotelService,
    private signinService: SigninService
  ) {}

  ngOnInit(): void {
    //getting user data from service
    this.loggedInUser = this.signinService.getUserLoginData();

    //getting booking details by user Id
    this.hotelService
      .getUserBookings(this.loggedInUser.userId)
      .subscribe((data) => {
        this.bookingData = data;
        console.log(this.bookingData);
      });
  }
}
