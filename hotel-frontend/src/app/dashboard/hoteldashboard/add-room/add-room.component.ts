import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css'],
})
export class AddRoomComponent implements OnInit {
  hotel: any;
  roomData: any = {};

  constructor(
    private signinService: SigninService,
    private hotelService: HotelService,
    private _snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    // getting hotel object
    this.hotel = this.signinService.getHotelLoginData();
  }

  onSubmit(form: any) {
    // room object to post
    this.roomData = {
      hotelId: {
        hotelId: this.hotel.hotelId,
      },
      roomNo: form.value.roomNo,
      roomType: form.value.roomType,
      ratePerDay: form.value.ratePerDay,
      isAvailable: 'Y',
    };
    // method to add room
    this.hotelService.addRoom(this.roomData).subscribe((data) => {
      // show successful snackbar
      this._snackBar.open('Room Added Successfully', '', {
        duration: 4000,
      });
      // reset all form values
      form.reset();
    });
  }
}
