import { Component, OnInit } from '@angular/core';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-hotel-payment',
  templateUrl: './hotel-payment.component.html',
  styleUrls: ['./hotel-payment.component.css'],
})
export class HotelPaymentComponent implements OnInit {
  hotel: any;
  allPaymentData:any = [];
  constructor(
    private hotelService: HotelService,
    private signinService: SigninService
  ) {}

  ngOnInit(): void {
    // To get hotel data
    this.hotel = this.signinService.getHotelLoginData();

    // get all hotel payments by Id
    this.hotelService.getAllPayment(this.hotel.hotelId).subscribe(data => {
      this.allPaymentData = data;
    })
  }
}
