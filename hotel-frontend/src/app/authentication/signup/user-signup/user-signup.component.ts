import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css'],
})
export class UserSignupComponent implements OnInit {
  userData: any = {};
  constructor(
    private signupService: SignupService,
    private _snackBar: MatSnackBar,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.signupService.signupUser(this.userData).subscribe((data) => {
      //snackbar to show user signed up successfully
      this._snackBar.open('User Registered Successfully please login in', '', {
        duration: 6000,
      });
      //navigate to login
      this.router.navigate(['/user-login']);
    });
  }
}
