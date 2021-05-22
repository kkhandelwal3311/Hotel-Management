import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-booked-room',
  templateUrl: './booked-room.component.html',
  styleUrls: ['./booked-room.component.css'],
})
export class BookedRoomComponent implements OnInit {
  constructor(
    private hotelService: HotelService,
    private signinService: SigninService,
    private activatedRoute: ActivatedRoute
  ) {}

  roomId: any;
  hotel: any;
  bookingDetail: any = [];

  roomBookingDetails: any = [];

  ngOnInit(): void {
    // for getting room id
    this.roomId = this.activatedRoute.snapshot.paramMap.get('id');
    this.roomId = parseInt(this.roomId);

    // for getting hotel data
    this.hotel = this.signinService.getHotelLoginData();

    // for getting all booking details of that hotel
    this.hotelService.getAllBookedRoom(this.hotel.hotelId).subscribe((data) => {
      this.bookingDetail = data;
    });
  }
}
