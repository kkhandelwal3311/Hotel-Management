import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './landing/landing.component';
import { AuthGuard } from './auth/auth.guard';
import { AdminSigninComponent } from './authentication/signin/admin-signin/admin-signin.component';
import { UserSigninComponent } from './authentication/signin/user-signin/user-signin.component';
import { HotelSignupComponent } from './authentication/signup/hotel-signup/hotel-signup.component';
import { UserSignupComponent } from './authentication/signup/user-signup/user-signup.component';
import { BookingDetailsComponent } from './dashboard/userdashboard/booking-details/booking-details.component';
import { HomeComponent } from './dashboard/userdashboard/home/home.component';
import { HotelDetailsComponent } from './dashboard/userdashboard/hotel-details/hotel-details.component';
import { PaymentComponent } from './dashboard/userdashboard/payment/payment.component';
import { TransactionComponent } from './dashboard/userdashboard/transaction/transaction.component';
import { UserProfileComponent } from './dashboard/userdashboard/user-profile/user-profile.component';
import { HotelDashboardComponent } from './dashboard/hoteldashboard/hotel-dashboard/hotel-dashboard.component';
import { AllRoomComponent } from './dashboard/hoteldashboard/all-room/all-room.component';
import { BookedRoomComponent } from './dashboard/hoteldashboard/booked-room/booked-room.component';
import { HotelPaymentComponent } from './dashboard/hoteldashboard/hotel-payment/hotel-payment.component';
import { AddRoomComponent } from './dashboard/hoteldashboard/add-room/add-room.component';
import { EditHotelComponent } from './dashboard/hoteldashboard/edit-hotel/edit-hotel.component';
import { UserBookingComponent } from './dashboard/userdashboard/user-booking/user-booking.component';

import { MasterComponent } from './authentication/signin/master/master.component';
import { MasterDashboardComponent } from './dashboard/masterdashboard/master-dashboard/master-dashboard.component';
import { MasterOverviewComponent } from './dashboard/masterdashboard/master-overview/master-overview.component';
import { MasterUserComponent } from './dashboard/masterdashboard/master-user/master-user.component';
import { MasterHotelComponent } from './dashboard/masterdashboard/master-hotel/master-hotel.component';
import { MasterPaymentComponent } from './dashboard/masterdashboard/master-payment/master-payment.component';
import { HotelProfileComponent } from './dashboard/hoteldashboard/hotel-profile/hotel-profile.component';

const routes: Routes = [
  { path: '', component: LandingComponent },
  // login and sign up routes
  { path: 'user-signup', component: UserSignupComponent },
  { path: 'user-login', component: UserSigninComponent },
  { path: 'hotel-login', component: AdminSigninComponent },
  { path: 'hotel-signup', component: HotelSignupComponent },
  { path: 'master-login', component: MasterComponent },
  // user module routes
  {
    path: 'user-dashboard',
    component: HomeComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'user-booking',
    component: UserBookingComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'user-profile',
    component: UserProfileComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'hotel-details/:id',
    component: HotelDetailsComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'booking-details',
    component: BookingDetailsComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'transaction',
    component: TransactionComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'payment/:tId/:bId',
    component: PaymentComponent,
    canActivate: [AuthGuard],
  },
  // hotel module routes
  {
    path: 'hotel-dashboard',
    component: HotelDashboardComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        redirectTo: 'all-rooms',
        pathMatch: 'full',
      },
      {
        path: 'all-rooms',
        component: AllRoomComponent,
      },
      {
        path: 'booked-rooms/:id',
        component: BookedRoomComponent,
      },
      {
        path: 'hotel-payment',
        component: HotelPaymentComponent,
      },
      {
        path: 'hotel-addroom',
        component: AddRoomComponent,
      },
      {
        path: 'hotel-editroom/:id',
        component: EditHotelComponent,
      },
      {
        path: 'hotel-profile',
        component: HotelProfileComponent,
      },
    ],
  },
  // admin module routes
  {
    path: 'master-dashboard',
    component: MasterDashboardComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        redirectTo: 'user',
        pathMatch: 'full',
      },
      {
        path: 'overview',
        component: MasterOverviewComponent,
      },
      {
        path: 'user',
        component: MasterUserComponent,
      },
      {
        path: 'hotel',
        component: MasterHotelComponent,
      },
      {
        path: 'payment',
        component: MasterPaymentComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
export const routingComponents = [
  HomeComponent,
  BookingDetailsComponent,
  TransactionComponent,
  PaymentComponent,
];
