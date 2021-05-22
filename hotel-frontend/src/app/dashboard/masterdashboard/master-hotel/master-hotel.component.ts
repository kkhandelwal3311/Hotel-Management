import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-master-hotel',
  templateUrl: './master-hotel.component.html',
  styleUrls: ['./master-hotel.component.css'],
})
export class MasterHotelComponent implements OnInit {
  allHotel: any;
  constructor(private adminService: AdminService, private router: Router) {}

  ngOnInit(): void {
    this.adminService.getAllHotel().subscribe((data) => {
      this.allHotel = data;
    });
  }
  get totalRows(): number {
    return this.allHotel.length;
  }
  deleteHotel(hotelId: number) {
    this.adminService.deleteHotel(hotelId).subscribe((data) => {
      this.allHotel = data;
      console.log(this.allHotel);
    });
  }
}
