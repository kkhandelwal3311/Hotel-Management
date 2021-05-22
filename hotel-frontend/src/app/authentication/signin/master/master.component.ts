import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SigninService } from '../signin.service';
import { UserClass } from '../user-signin/user-class';

@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.css'],
})
export class MasterComponent implements OnInit {
  masterData = new UserClass('', '');
  errMessage = '';
  constructor(private signinService: SigninService, private router: Router) {}

  ngOnInit(): void {}
  onSubmit() {
    console.log(this.masterData);
    this.signinService.masterLogin(this.masterData).subscribe(
      (masterData) => {
        this.signinService.setMasterLoginData(masterData.admin);
        //setting in session storage
        sessionStorage.setItem('username', masterData.admin.adminName);
        let tokenStr = 'Bearer ' + masterData.token;
        //setting token in storage
        sessionStorage.setItem('token', tokenStr);
        //navigating to admin dashboard
        this.router.navigate(['/master-dashboard']);
      },
      (error) => {
        this.errMessage = error;
      }
    );
  }
}
