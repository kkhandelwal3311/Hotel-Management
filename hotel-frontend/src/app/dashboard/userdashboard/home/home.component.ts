import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SigninService } from 'src/app/authentication/signin/signin.service';
import { HotelService } from './hotel.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  data: any;
  filterTerm: any;
  allHotelData: any = [];
  listedData: any = [];
  letfilterCity: string[] = [];
  checkedArray: any = [];

  constructor(
    private signinService: SigninService,
    private hotelService: HotelService,
    private router: Router
  ) {}

  ngOnInit(): void {
    //get user data
    this.data = this.signinService.getUserLoginData();

    //main component
    this.hotelService.getAllHotel().subscribe((data) => {
      console.log(data);
      this.allHotelData = data;
      this.listedData = this.allHotelData;
    });
  }

  getHotelRooms(selectedHotelId: number) {
    this.router.navigate(['/hotel-details', selectedHotelId]);
  }

  GetStats(event: any, value: any) {
    // console.log(event);
    // console.log(value);
    // if(checkbox type === price){
    //   this.checkedPrice = push or remove
    // }else if(){

    // } else {
    if (event == true) {
      this.checkedArray.push(value);
      // this.listedData = this.allHotelData.filter((a: { city: any; }) => a.city == value);
    } else {
      let index = this.checkedArray.indexOf(value);
      this.checkedArray.splice(index, 1);
      // this.listedData = this.allHotelData.fi
    }
    // }
    this.listedData =
      this.checkedArray.length > 0
        ? this.allHotelData.filter((a: { city: any }) =>
            this.checkedArray.includes(a.city)
          )
        : this.allHotelData;
    console.log(this.checkedArray);
    // this.ref.markForCheck();
  }
}
