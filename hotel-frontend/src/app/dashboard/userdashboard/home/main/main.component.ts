import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  constructor(private hotelService: HotelService, private router: Router) {}

  allHotelData: any = [];

  ngOnInit(): void {
    this.hotelService.getAllHotel().subscribe((data) => {
      console.log(data);
      this.allHotelData = data;
    });
  }

  getHotelRooms(selectedHotelId: number) {
    this.router.navigate(['/hotel-details', selectedHotelId]);
  }
}
