import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserClass } from './user-signin/user-class';

@Injectable({
  providedIn: 'root',
})
export class SigninService {
  constructor(private http: HttpClient, private router: Router) {}

  user: any;
  hotel: any;
  master: any;

  //user login
  userLogin(userData: UserClass) {
    return this.http.post<any>(
      'http://localhost:8090/api/user/authenticate',
      userData
    );
  }

  //set user session storage
  setUserLoginData(userData: UserClass) {
    sessionStorage.getItem('userdata')
      ? sessionStorage.removeItem('userdata')
      : '';
    this.user = userData;
    sessionStorage.setItem('userdata', JSON.stringify(this.user));
  }

  //get user session storage
  getUserLoginData() {
    this.user = sessionStorage.getItem('userdata');
    return JSON.parse(this.user);
  }

  //logout user
  logoutUser() {
    sessionStorage.removeItem('userdata');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('booking');
    sessionStorage.removeItem('token');
    this.router.navigate(['/']);
  }

  //hotel login
  hotelLogin(hotelData: any) {
    return this.http.post<any>(
      'http://localhost:8090/api/hotel/authenticate',
      hotelData
    );
  }

  //set hotel session storage
  setHotelLoginData(hotelData: any) {
    sessionStorage.getItem('hoteldata')
      ? sessionStorage.removeItem('hoteldata')
      : '';
    this.hotel = hotelData;
    console.log(this.hotel);
    sessionStorage.setItem('hoteldata', JSON.stringify(this.hotel));
  }

  //get hotel session storage
  getHotelLoginData() {
    this.hotel = sessionStorage.getItem('hoteldata');
    return JSON.parse(this.hotel);
  }

  //hotel logout
  logoutHotel() {
    sessionStorage.removeItem('hoteldata');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
    this.router.navigate(['/']);
  }

  //check token for auth
  isLoggedIn() {
    return !!sessionStorage.getItem('token');
  }

  //master login and session
  masterLogin(masterData: any) {
    return this.http.post<any>(
      'http://localhost:8090/api/admin/authenticate',
      masterData
    );
  }

  //set admin session storage
  setMasterLoginData(masterData: any) {
    sessionStorage.getItem('masterdata')
      ? sessionStorage.removeItem('masterdata')
      : '';
    this.master = masterData;
    sessionStorage.setItem('masterdata', JSON.stringify(this.master));
  }

  //get admin session storage
  getMasterLoginData() {
    this.master = sessionStorage.getItem('masterdata');
    return JSON.parse(this.master);
  }

  //master logout
  logoutMaster() {
    sessionStorage.removeItem('masterdata');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
    this.router.navigate(['/']);
  }
}
