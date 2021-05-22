import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaymentService } from './payment.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent implements OnInit {
  transactionId: any;
  bookingId: any;
  paymentData: any = {};

  constructor(
    private activatedRoute: ActivatedRoute,
    private paymentService: PaymentService
  ) {}

  ngOnInit(): void {
    //get transaction Id by path
    this.transactionId = this.activatedRoute.snapshot.paramMap.get('tId');

    //get booking Id by path
    this.bookingId = this.activatedRoute.snapshot.paramMap.get('bId');

    //create booking object
    this.paymentData = {
      bookingId: {
        bookingId: parseInt(this.bookingId),
      },
      transactionId: {
        transactionId: parseInt(this.transactionId),
      },
    };
    //add payment
    this.paymentService.addPayment(this.paymentData).subscribe((data) => {
      // get added payment
      this.paymentService.getOnePayment(data.paymentId).subscribe((data) => {
        this.paymentData = data;
      });
    });
  }
}
