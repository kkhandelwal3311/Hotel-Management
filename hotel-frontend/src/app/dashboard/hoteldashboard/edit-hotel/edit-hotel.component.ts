import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-edit-hotel',
  templateUrl: './edit-hotel.component.html',
  styleUrls: ['./edit-hotel.component.css'],
})
export class EditHotelComponent implements OnInit {
  roomId: any;
  roomToEdit: any;
  constructor(
    private activatedRoute: ActivatedRoute,
    private hotelService: HotelService,
    private signinService: SigninService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // for getting room id
    this.roomId = this.activatedRoute.snapshot.paramMap.get('id');
    this.roomId = parseInt(this.roomId);

    // get room by roomId
    this.hotelService.getRoomById(this.roomId).subscribe((data) => {
      this.roomToEdit = data;
      console.log(data);
    });
  }

  onSubmit() {
    //edit room method
    this.hotelService.editRoom(this.roomToEdit).subscribe((data) => {
      this.router.navigate(['/hotel-dashboard/all-rooms']);
    });
  }
}
