import { Component, OnInit } from '@angular/core';
import { SigninService } from 'src/app/authentication/signin/signin.service';

@Component({
  selector: 'app-master-dashboard',
  templateUrl: './master-dashboard.component.html',
  styleUrls: ['./master-dashboard.component.css'],
})
export class MasterDashboardComponent implements OnInit {
  constructor(private signinService: SigninService) {}

  ngOnInit(): void {}
  logoutMaster() {
    this.signinService.logoutMaster();
  }
}
