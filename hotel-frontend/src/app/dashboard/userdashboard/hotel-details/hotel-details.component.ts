import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RoomService } from './room.service';
import { DatePipe } from '@angular/common';
import { Booking } from './booking';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { DataService } from 'src/app/common/data-service/data.service';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.css'],
})
export class HotelDetailsComponent implements OnInit {
  userData: any;
  public hotelId: any = '0';
  rooms: any = [];

  // date = new Date();
  minimumDate =
    new Date().getFullYear().toString() +
    '-0' +
    (new Date().getMonth() + 1).toString() +
    '-' +
    new Date().getDate().toString();

  dateToSend: any = {};

  bookingDetails: Booking = {
    hotelId: {
      hotelId: 0,
    },
    roomId: {
      roomId: 0,
    },
    userId: {
      userId: 0,
    },
    bookedFrom: '',
    bookedTo: '',
    noOfAdults: 0,
    noOfChildren: 0,
    amount: 0,
  };

  constructor(
    private activatedRoute: ActivatedRoute,
    private roomService: RoomService,
    private signinService: SigninService,
    private dataService: DataService
  ) {}

  ngOnInit(): void {
    //get hotel Id from path
    this.hotelId = this.activatedRoute.snapshot.paramMap.get('id');
    // get logged user data
    this.userData = this.signinService.getUserLoginData();
  }

  // set booking data in session storage
  sendBookingData(formData: any, room: any) {
    //create bokoing object
    this.bookingDetails = {
      hotelId: {
        hotelId: parseInt(this.hotelId),
      },
      roomId: {
        roomId: room.roomId,
      },
      userId: {
        userId: this.userData.userId,
      },
      bookedFrom: formData.bookedFrom,
      bookedTo: formData.bookedTo,
      noOfAdults: formData.noOfAdult,
      noOfChildren: formData.noOfChildren,
      amount: room.ratePerDay,
    };
    // call function to set data
    this.dataService.setBookingDetails(this.bookingDetails);
  }

  // get available rooms by dates
  getAvailableRooms() {
    // send dates object
    this.dateToSend = {
      bookedFrom: this.bookingDetails.bookedFrom,
      bookedTo: this.bookingDetails.bookedTo,
    };
    // getting rooms
    this.roomService
      .getAvailableRooms(this.dateToSend, this.hotelId)
      .subscribe((data) => {
        // setting data to local array
        this.rooms = data;
      });
  }
}
