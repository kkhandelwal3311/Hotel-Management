import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-hotel-signup',
  templateUrl: './hotel-signup.component.html',
  styleUrls: ['./hotel-signup.component.css'],
})
export class HotelSignupComponent implements OnInit {
  hotelData = {
    city: '',
    hotelName: '',
    address: '',
    description: '',
    avgRatePerDay: '',
    email: '',
    password: '',
    phone1: '',
    phone2: '',
    website: '',
  };
  constructor(
    private signupService: SignupService,
    private _snackBar: MatSnackBar,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.signupService.signupHotel(this.hotelData).subscribe((data) => {
      //snackbar to show hotel signed up successfully
      this._snackBar.open('Hotel Registered Successfully please login in', '', {
        duration: 6000,
      });
      //navigate to login
      this.router.navigate(['/hotel-login']);
    });
  }
}
