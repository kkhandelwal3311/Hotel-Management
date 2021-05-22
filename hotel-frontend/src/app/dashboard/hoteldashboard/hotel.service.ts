import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class HotelService {
  constructor(private http: HttpClient) {}

  // get all rooms of hotel
  getAllRoom(hotelId: number) {
    return this.http.get<any>(
      `http://localhost:8090/api/room/hotel/${hotelId}`
    );
  }

  // get all booked rooms of hotel
  getAllBookedRoom(hotelId: number) {
    return this.http.get<any>(
      `http://localhost:8090/api/room/bookedroom/${hotelId}`
    );
  }

  // get all payments of hotel
  getAllPayment(hotelId: number) {
    return this.http.get<any>(
      `http://localhost:8090/api/room/payment/${hotelId}`
    );
  }

  // adding room
  addRoom(roomData: any) {
    return this.http.post<any>('http://localhost:8090/api/room', roomData);
  }

  // get one room
  getRoomById(roomId: number) {
    return this.http.get<any>(`http://localhost:8090/api/room/${roomId}`);
  }

  // edit room
  editRoom(roomData: any) {
    return this.http.put<any>('http://localhost:8090/api/room', roomData);
  }

  // delete room
  deleteRoom(roomId: number) {
    return this.http.delete(`http://localhost:8090/api/room/${roomId}`);
  }

  //edit hotel
  editHotel(hotelToEdit: any) {
    return this.http.put<any>('http://localhost:8090/api/hotel', hotelToEdit);
  }
}
