import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private router:Router, private http:HttpClient) { }

  //get all hotels
  getAllHotel(){
    return this.http.get('http://localhost:8090/api/hotel')
  }

  //get all bookings of user
  getUserBookings(userId:number){
    return this.http.get(`http://localhost:8090/api/user/booking/${userId}`)
  }

  //edit user data
  editUser(user:any){
    return this.http.put<any>('http://localhost:8090/api/user',user)
  }
}
