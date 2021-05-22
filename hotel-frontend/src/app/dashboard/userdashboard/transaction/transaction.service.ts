import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../hotel-details/booking';

@Injectable({
  providedIn: 'root',
})
export class TransactionService {
  constructor(private http: HttpClient) {}

  // adding transaction
  addTransaction(transaction: any) {
    return this.http.post<any>(
      'http://localhost:8090/api/transaction',
      transaction
    );
  }

  // adding booking
  addBooking(bookingDetails: any) {
    return this.http.post<any>(
      'http://localhost:8090/api/booking',
      bookingDetails
    );
  }
}
