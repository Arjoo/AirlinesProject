//Angulars
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DatepickerModule} from 'ng2-bootstrap';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';

//Component
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { FlightSearchComponent } from './flight-search/flight-search.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { FlightBookingComponent } from './flight-booking/flight-booking.component';
import { ForgetComponent } from './forget/forget.component';

//Services
import { FlightBookingService } from './services/flightBook-services/flight-booking.service';
import { LoginService } from './services/loginService-service/login.service';
import { SignupService } from './services/signUp-service/signup.service';
import { ForgotPasswordService } from './services/forgotPassword-service/forgot-password.service';
import { UserProfileService }from './services/userProfile-services/user-profile.service'
import { SearchFlightService } from './services/searchFlight-service/search-flight.service';
import { StorageService } from './storage/storage.service';

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginFormComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'flightSearch', component: FlightSearchComponent },
  { path: 'flightbook', component: FlightBookingComponent },
  { path: 'forget', component: ForgetComponent },
  { path: 'userProfile', component: UserProfileComponent }
];



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginFormComponent,
    FooterComponent,
    HomeComponent,
    SignupComponent,
    FlightSearchComponent,
    FlightBookingComponent,
    ForgetComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    DatepickerModule.forRoot(),
    FormsModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [
    SearchFlightService,
    LoginService,
    SignupService,
    ForgotPasswordService,
    FlightBookingService,
    UserProfileService,
    StorageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
