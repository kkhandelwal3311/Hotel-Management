import { Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-all-room',
  templateUrl: './all-room.component.html',
  styleUrls: ['./all-room.component.css'],
})
export class AllRoomComponent implements OnInit {
  hotel: any;
  allRoomData: any = [];
  constructor(
    private hotelService: HotelService,
    private signinService: SigninService,
    private router: Router,
    private _snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    // get hotel data
    this.hotel = this.signinService.getHotelLoginData();

    // get all rooms of hotel method
    this.hotelService.getAllRoom(this.hotel.hotelId).subscribe((data) => {
      console.log(data);
      this.allRoomData = data;
    });
  }

  // navigate to booked rooms component
  roomBookingDetails(roomId: number) {
    this.router.navigate(['/hotel-dashboard/booked-rooms', roomId]);
  }

  //edit room details
  editRoom(roomId: number) {
    this.router.navigate(['/hotel-dashboard/hotel-editroom', roomId]);
  }

  // delete room by Id
  deleteRoom(roomId: number) {
    this.hotelService.deleteRoom(roomId).subscribe(
      (data) => {
        this.allRoomData = data;
        this._snackBar.open('Room Deleted Successfully', '', {
          duration: 4000,
        });
      },
      (error) => {
        this._snackBar.open('Cannot delete this room as it is booked', '', {
          duration: 7000,
        });
      }
    );
  }
}
