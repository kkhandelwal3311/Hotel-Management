import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { SigninService } from '../authentication/signin/signin.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private signinService: SigninService, private router: Router) {}

  canActivate(): boolean {
    if (this.signinService.isLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/user-login']);
      return false;
    }
  }
}
