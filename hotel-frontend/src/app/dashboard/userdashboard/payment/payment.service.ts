import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class PaymentService {
  constructor(private http: HttpClient, private router: Router) {}

  // add payment
  addPayment(paymentData: any) {
    return this.http.post<any>(
      'http://localhost:8090/api/payment',
      paymentData
    );
  }

  // get payment by Id
  getOnePayment(paymentId: any) {
    return this.http.get<any>(`http://localhost:8090/api/payment/${paymentId}`);
  }
}
