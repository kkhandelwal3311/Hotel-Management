import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.css'],
})
export class BookingDetailsComponent implements OnInit {
  //room data and booking data from hotel-details component
  @Input() bookingData: any;
  @Input() roomData: any;

  constructor() {}

  ngOnInit(): void {}
}
