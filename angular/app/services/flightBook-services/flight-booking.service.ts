import { Injectable } from '@angular/core';
  import { Http, Response, Headers, RequestOptions } from '@angular/http';


@Injectable()
export class FlightBookingService {

  constructor(private http: Http) { }

  getLoggedInUserDetails(userId) {
        
        return this.http.post('http://localhost:8080/user', new User(userId))
        	.map(response => response.json());
  }

  getFlightDetails(flightId) {
        return this.http.post('http://localhost:8080/flight', new BookFlight(flightId))
        	.map(response => response.json());
  }

  bookFlightTicket(bookingFlightObj) {
      return this.http.post('http://localhost:8080/bookTicket', bookingFlightObj)
        	.map(response => response.json());
  }

}


class User {
    constructor(public userId?: number){}
}


class BookFlight {
  constructor(public flightId?: number){}
}
