import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/common/data-service/data.service';
import { TransactionService } from './transaction.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css'],
})
export class TransactionComponent implements OnInit {
  data = {
    Number: '',
    Exp_Date: '',
    Cvv: '',
  };
  constructor(
    private dataService: DataService,
    private transactionService: TransactionService,
    private router: Router
  ) {}

  bookingDetails: any;
  transactionData: any;

  ngOnInit(): void {
    //get booking details from service
    this.bookingDetails = this.dataService.getBookingDetails();
  }

  onSubmit() {
    // transaction object to send
    this.transactionData = {
      amount: this.bookingDetails.amount,
    };
    // transaction service method to save transaction
    this.transactionService
      .addTransaction(this.transactionData)
      .subscribe((data) => {
        this.transactionData = data;
        // transaction service method to save booking
        this.transactionService
          .addBooking(this.bookingDetails)
          .subscribe((data) => {
            this.bookingDetails = data;
            // navigate to payment page with transactionId and bookingId
            this.router.navigate([
              '/payment',
              this.transactionData.transactionId,
              this.bookingDetails.bookingId,
            ]);
          });
      });
  }
}
