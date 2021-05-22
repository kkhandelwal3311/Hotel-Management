import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SigninService } from '../signin.service';
import { UserClass } from './user-class';

@Component({
  selector: 'app-user-signin',
  templateUrl: './user-signin.component.html',
  styleUrls: ['./user-signin.component.css'],
})
export class UserSigninComponent implements OnInit {
  userData = new UserClass('', '');
  errMessage = '';

  constructor(private signinService: SigninService, private router: Router) {}
  ngOnInit(): void {}

  onSubmit() {
    this.signinService.userLogin(this.userData).subscribe(
      (userData) => {
        this.signinService.setUserLoginData(userData.user);
        //setting in session storage
        sessionStorage.setItem('username', userData.user.userName);
        let tokenStr = 'Bearer ' + userData.token;
        //setting token in storage
        sessionStorage.setItem('token', tokenStr);
        //navigating to user dashboard
        this.router.navigate(['/user-dashboard']);
      },
      (error) => {
        this.errMessage = error;
      }
    );
  }

  openHotelLogin() {
    this.router.navigate(['/hotel-login']);
  }
}
