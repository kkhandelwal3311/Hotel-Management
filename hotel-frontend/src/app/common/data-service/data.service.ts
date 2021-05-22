import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  bookingDetails: any;

  constructor() {}

  //set booking session storage
  setBookingDetails(bookingData: any) {
    sessionStorage.getItem('booking')
      ? sessionStorage.removeItem('booking')
      : '';
    this.bookingDetails = bookingData;
    sessionStorage.setItem('booking', JSON.stringify(this.bookingDetails));
  }

  //get booking session storage
  getBookingDetails() {
    if (this.bookingDetails != null) {
      return this.bookingDetails;
    }
    this.bookingDetails = sessionStorage.getItem('booking');
    return JSON.parse(this.bookingDetails);
  }
}
