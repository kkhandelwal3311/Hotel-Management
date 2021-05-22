import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SigninService } from '../signin.service';
import { UserClass } from '../user-signin/user-class';

@Component({
  selector: 'app-admin-signin',
  templateUrl: './admin-signin.component.html',
  styleUrls: ['./admin-signin.component.css'],
})
export class AdminSigninComponent implements OnInit {
  constructor(private signinService: SigninService, private router: Router) {}

  hotelData = new UserClass('', '');
  errMessage = '';

  ngOnInit(): void {}

  onSubmit() {
    this.signinService.hotelLogin(this.hotelData).subscribe(
      (hotelData) => {
        this.signinService.setHotelLoginData(hotelData.hotel);
        //setting in session storage
        sessionStorage.setItem('username', hotelData.hotel.hotelName);
        let tokenStr = 'Bearer ' + hotelData.token;
        //setting token in storage
        sessionStorage.setItem('token', tokenStr);
        //navigating to hotel dashboard
        this.router.navigate(['/hotel-dashboard']);
      },
      (error) => {
        this.errMessage = error;
      }
    );
  }

  openUserLogin() {
    this.router.navigate(['/user-login']);
  }
}
