import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  constructor(private http: HttpClient) {}

  //user signup
  signupUser(userData: any) {
    return this.http.post<any>(
      'http://localhost:8090/api/user/register',
      userData
    );
  }

  //hotel signup
  signupHotel(hotelData: any) {
    return this.http.post<any>(
      'http://localhost:8090/api/hotel/register',
      hotelData
    );
  }
}
