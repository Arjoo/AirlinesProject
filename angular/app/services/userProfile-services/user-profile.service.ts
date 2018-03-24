import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

@Injectable()
export class UserProfileService {

  constructor(private http: Http) { }


  getLoggedInUserDetails(userId) {
        return this.http.post('http://localhost:8080/user', new User(userId))
        	.map(response => response.json());
  }

  getBookedFlightDetails(userId) {
        return this.http.post('http://localhost:8080/bookedFlights', new User(userId))
        	.map(response => response.json());
  }

}

class User {
    constructor(public userId?: number){}
}