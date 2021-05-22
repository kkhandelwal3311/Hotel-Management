import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  constructor(private http: HttpClient) {}

  // get all users
  getAllUser() {
    return this.http.get('http://localhost:8090/api/admin/user');
  }
  // get all hotels
  getAllHotel() {
    return this.http.get('http://localhost:8090/api/admin/hotel');
  }
  // get all payments
  getAllPayment() {
    return this.http.get<any>('http://localhost:8090/api/admin/payment');
  }
  // get all booking
  getAllBooking() {
    return this.http.get('http://localhost:8090/api/admin/booking');
  }
  // delete room
  deleteUser(userId: number) {
    return this.http.delete(`http://localhost:8090/api/admin/user/${userId}`);
  }

  deleteHotel(hotelId: number) {
    return this.http.delete(`http://localhost:8090/api/admin/hotel/${hotelId}`);
  }
}
