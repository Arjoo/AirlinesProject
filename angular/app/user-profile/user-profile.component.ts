import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Http, Response, Headers } from '@angular/http';

import { UserProfileService } from '../services/userProfile-services/user-profile.service';
import { StorageService } from '../storage/storage.service';



@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  flightId : number;
  userId : string;
  storage : Map<string, any> ;
  bookedFlightList = {
      userId : "",
      bookingDate : "",
      tripDate : "",
      trip : "",
      bookingId : 0
  };
  
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
  constructor(
      private userProfileService : UserProfileService,
      private storageService : StorageService,
      private _http: Http,
      private route: ActivatedRoute,
      private router: Router) { 
          

/**
          this.route.params.subscribe(params => {
                this.userId = params.userId;
          });
*/
  }

  ngOnInit() {
      this.storage = this.storageService.getStorage();
      this.loadIfo();
  }

  loadIfo() {
      //userProfileService

      let userId = this.storage.get('userId');
      if(!userId) {
            this.router.navigate(['../login']);
            return;
      }

      this.userProfileService.getLoggedInUserDetails(userId)
        .subscribe(
            data => {
                this.user = data;
                console.log("From user profile   " + this.user.firstname  + "   " + this.user.lastname );
            }
        );
        
      this.userProfileService.getBookedFlightDetails(userId)
        .subscribe(
            data => {
                this.bookedFlightList = data;
                //console.log("bookedFlightList  " + this.bookedFlightList[0]);
                //this.bookedFlightList.reverse();
            }
        );
  }

}
