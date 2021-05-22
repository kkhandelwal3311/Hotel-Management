import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RoomService {
  constructor(private http: HttpClient) {}

  //get rooms of hotel
  getHotelRooms(hotelId: number) {
    return this.http.get(`http://localhost:8090/api/room/hotel/${hotelId}`);
  }

  // get available rooms
  getAvailableRooms(dateToSend: any, hotelId: number) {
    return this.http.post(
      `http://localhost:8090/api/room/availablehotel/${hotelId}`,
      dateToSend
    );
  }
}
