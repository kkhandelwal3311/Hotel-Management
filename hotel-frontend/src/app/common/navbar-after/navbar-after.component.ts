import { Component, OnInit } from '@angular/core';
import { SigninService } from 'src/app/authentication/signin/signin.service';

@Component({
  selector: 'app-navbar-after',
  templateUrl: './navbar-after.component.html',
  styleUrls: ['./navbar-after.component.css'],
})
export class NavbarAfterComponent implements OnInit {
  constructor(private siginService: SigninService) {}

  userData: any;
  ngOnInit(): void {
    //get user login data
    this.userData = this.siginService.getUserLoginData();
  }

  logoutUser() {
    //logout user
    this.siginService.logoutUser();
  }
}
