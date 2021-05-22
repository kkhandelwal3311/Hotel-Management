import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { MasterUserComponent } from '../master-user/master-user.component';

@Component({
  selector: 'app-master-overview',
  templateUrl: './master-overview.component.html',
  styleUrls: ['./master-overview.component.css'],
})
export class MasterOverviewComponent implements OnInit {
  allUser: any;

  allHotel: any;

  allPayment: any;

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    // get all user data
    this.adminService.getAllUser().subscribe((data) => {
      this.allUser = data;
    });

    // get all hotel data
    this.adminService.getAllHotel().subscribe((data) => {
      this.allHotel = data;
    });

    // get all payment data
    this.adminService.getAllPayment().subscribe((data) => {
      this.allPayment = data;
    });
  }
}
