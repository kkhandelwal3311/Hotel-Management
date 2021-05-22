import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-hotel-profile',
  templateUrl: './hotel-profile.component.html',
  styleUrls: ['./hotel-profile.component.css'],
})
export class HotelProfileComponent implements OnInit {
  isDisabled: boolean = true;
  hotelData: any;
  constructor(
    private signinService: SigninService,
    private hotelService: HotelService
  ) {}

  ngOnInit(): void {
    //get hotel data
    this.hotelData = this.signinService.getHotelLoginData();
  }

  changeDisabled() {
    this.isDisabled = !this.isDisabled;
  }

  editHotel() {
    this.hotelService.editHotel(this.hotelData).subscribe((userData) => {
      // set hotel data to session storage
      this.signinService.setHotelLoginData(userData);
      //set username
      sessionStorage.setItem('username', userData.hotelName);
      this.isDisabled = true;
    });
  }
}
