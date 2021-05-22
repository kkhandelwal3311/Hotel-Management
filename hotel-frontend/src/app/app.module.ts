import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserSigninComponent } from './authentication/signin/user-signin/user-signin.component';
import { AdminSigninComponent } from './authentication/signin/admin-signin/admin-signin.component';

import { HotelSignupComponent } from './authentication/signup/hotel-signup/hotel-signup.component';
import { LandingComponent } from './landing/landing.component';
import { DrawerComponent } from './dashboard/userdashboard/home/drawer/drawer.component';
import { MainComponent } from './dashboard/userdashboard/home/main/main.component';
import { HotelDetailsComponent } from './dashboard/userdashboard/hotel-details/hotel-details.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { DatePipe } from '@angular/common';
import { TokenInterceptorService } from './token-interceptor.service';
import { NavbarAfterComponent } from './common/navbar-after/navbar-after.component';
import { NavbarBeforeComponent } from './common/navbar-before/navbar-before.component';
import { UserProfileComponent } from './dashboard/userdashboard/user-profile/user-profile.component';
import { RouterModule } from '@angular/router';
import { HotelDashboardComponent } from './dashboard/hoteldashboard/hotel-dashboard/hotel-dashboard.component';
import { HotelNavbarComponent } from './common/hotel-navbar/hotel-navbar.component';
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
import { BrandNavbarComponent } from './common/brand-navbar/brand-navbar.component';
import { filterPipe } from './dashboard/userdashboard/home/filter.pipe';
import { UserSignupComponent } from './authentication/signup/user-signup/user-signup.component';

@NgModule({
  declarations: [
    AppComponent,
    UserSigninComponent,
    AdminSigninComponent,
    UserSignupComponent,
    HotelSignupComponent,
    LandingComponent,
    DrawerComponent,
    MainComponent,
    HotelDetailsComponent,
    routingComponents,
    NavbarAfterComponent,
    NavbarBeforeComponent,
    UserProfileComponent,
    HotelDashboardComponent,
    HotelNavbarComponent,
    AllRoomComponent,
    BookedRoomComponent,
    HotelPaymentComponent,
    AddRoomComponent,
    EditHotelComponent,
    UserBookingComponent,
    MasterComponent,
    MasterDashboardComponent,
    MasterOverviewComponent,
    MasterUserComponent,
    MasterHotelComponent,
    MasterPaymentComponent,
    HotelProfileComponent,
    BrandNavbarComponent,
    filterPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [
    DatePipe,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
