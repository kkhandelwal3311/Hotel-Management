import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-master-user',
  templateUrl: './master-user.component.html',
  styleUrls: ['./master-user.component.css'],
})
export class MasterUserComponent implements OnInit {
  allUser: any;
  userLength: any;

  constructor(private adminService: AdminService, private router: Router) {}

  ngOnInit(): void {
    this.adminService.getAllUser().subscribe((data) => {
      this.allUser = data;
    });
  }

  deleteUser(userId: number) {
    this.adminService.deleteUser(userId).subscribe((data) => {
      this.allUser = data;
      console.log(this.allUser);
    });
  }
}
