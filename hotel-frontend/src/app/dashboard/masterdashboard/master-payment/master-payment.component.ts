import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-master-payment',
  templateUrl: './master-payment.component.html',
  styleUrls: ['./master-payment.component.css'],
})
export class MasterPaymentComponent implements OnInit {
  allPayment: any;
  constructor(private adminService: AdminService, private router: Router) {}

  ngOnInit(): void {
    // get all payments
    this.adminService.getAllPayment().subscribe((data) => {
      this.allPayment = data;
    });
  }
}
