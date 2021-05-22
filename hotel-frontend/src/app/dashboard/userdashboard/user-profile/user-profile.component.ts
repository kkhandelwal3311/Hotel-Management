import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../home/hotel.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  loggedInUser: any;
  isDisabled: boolean = true;

  constructor(
    private hotelService: HotelService,
    private signinService: SigninService,
    private router: Router
  ) {}

  ngOnInit(): void {
    //getting user data from service
    this.loggedInUser = this.signinService.getUserLoginData();
  }
  
  changeDisabled(){
    this.isDisabled = !this.isDisabled;
  }

  onSubmit(){
    // user object to edit
    const userToEdit = {
      userId: this.loggedInUser.userId,
      userName: this.loggedInUser.userName,
      email: this.loggedInUser.email,
      password: this.loggedInUser.password,
      role: this.loggedInUser.role,
      mobile: this.loggedInUser.mobile,
      address: this.loggedInUser.address
    }
    this.hotelService.editUser(userToEdit).subscribe(userData => {
      this.signinService.setUserLoginData(userData)
      sessionStorage.setItem('username', userData.userName);
      this.isDisabled = true;
    }) 
  }
}
