import { SearchFlight } from './../model/searchFlightInfo/search-flight.model';
import { flights } from './../model/filght/flights.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Http, Response, Headers } from '@angular/http';
import { DatePipe }             from '@angular/common';
import { Observable } from 'rxjs';

import { FlightBookingService } from '../services/flightBook-services/flight-booking.service';
import { StorageService } from '../storage/storage.service';
//import { SearchFlight }         from '../model/searchFlightInfo/search-flight.model';

@Component({
  selector: 'app-flight-booking',
  templateUrl: './flight-booking.component.html',
  styleUrls: ['./flight-booking.component.css']
})
export class FlightBookingComponent implements OnInit {

  flightId : number;
  userId : string;
  userProfileIcon = false;
  storage : Map<string, any> ;

  user = {
      firstname : "",
      middlename : "",
      lastname : "",
      email : "",
      password : "",
      confirmpassword : "",
      country : "",
      mobilenumber : 0
  };

  flight = {
      flightId: 0,
      flightNumber: "",
      flightName : "",
      flightDeparture : "",
      flightArrival : "",
      flightDuration : "",
      flightPrice : 0.0,
      flightSource : "",
	    flightDestination : "",
      flightDepartureDate : new Date()
   }

   bookingFlightObj = {
       userId : "",
       bookingDate : "",
       tripDate : "",
       trip : "",
       bookingId : 0,
   }

  //searchFlightInfo  : SearchFlight;

  constructor(
              private _http: Http,
              private route: ActivatedRoute,
              private router: Router,
              private flightBookingService : FlightBookingService,
              private storageService : StorageService) {

/**
        this.route.params.subscribe(params => {
        this.flightId = params.flightId;
        this.userId = params.userId;

        //console.log('this.flightId : ' + this.flightId + ",  this.userId : " + this.userId);
      
    });
    */

  }

  ngOnInit() {
      this.storage = this.storageService.getStorage();
      this.loadIfo();
  }

  titles = [
       {id: 0, name: "Title"},
       {id: 1, name: "Mr."},
       {id: 2, name: "Mrs."},
       {id: 3, name: "Ms"}
  ];

  loadIfo() {

        let userId = this.storage.get('userId');
        let flightId = this.storage.get('flightId');

        if(!userId) {
            this.router.navigate(['../login']);
            return;
        }

        if(userId)
          this.userProfileIcon = true;

        this.flightBookingService.getLoggedInUserDetails(userId).subscribe(
            data => {
                this.user = data;
                this.storageService.addToStorage('userDetails', this.user);
                console.log("SSSSSSSSSSSSSSSS   " + this.user.firstname);
            }
        );

        this.flightBookingService.getFlightDetails(flightId).subscribe(
            data => {
                this.flight = data;
                console.log("this.searchFlightInfo.id   " + this.flight.flightId);
            }
        );

        
  }

  bookTicket() {

      
      console.log("Calling function bookTicket")
      this.bookingFlightObj.tripDate    = this.convertDate(this.flight.flightDepartureDate);
      this.bookingFlightObj.trip        = this.flight.flightSource + "-" + this.flight.flightDestination;
      this.bookingFlightObj.bookingDate = this.convertDate(new Date());
      this.bookingFlightObj.userId      = this.storage.get('userId');

      this.flightBookingService.bookFlightTicket(this.bookingFlightObj).subscribe(
            data => {
                this.bookingFlightObj = data;
                console.log(" bookFlightTicket----  " + this.bookingFlightObj.bookingId);
            });

      let bookingId = this.bookingFlightObj.bookingId;
      if(bookingId)
            this.storageService.addToStorage('bookingMessage', "Congratulations! Your ticket booked successfully");
      this.router.navigate(['/userProfile']);
      console.log("");
  }

  convertDate(date) : any {
      var departDatePipe = new DatePipe("en-US");
      let dateInString = departDatePipe.transform(date, 'yyyy-MM-dd');
      return dateInString;
  }


  userProfile() {
      this.router.navigate(['/userProfile']);
  }
}

