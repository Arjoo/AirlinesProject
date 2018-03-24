import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Http, Response, Headers } from '@angular/http';

import { SignupService } from '../services/signUp-service/signup.service';


interface Countries {
    id : number,
    name : string
}

class Country {
  constructor(public id : number, public name : string) {}
}

interface Message {
    msg : string
}


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signup = {
      firstname : "",
      middlename : "",
      lastname : "",
      email : "",
      password : "",
      confirmpassword : "",
      country : "",
      mobilenumber : 0
  };

  signupVerify = {};
  firstnameErrorMsg: string;
  passwordErrorMsg: string;
  countryErrorMsg: string;
  msg : string;
  errorMsg : string;


  countryList : Countries[];
  countries : Countries;
  constructor(private http: Http,
      private route: ActivatedRoute,
      private router: Router,
      private signupService : SignupService,) { }

  ngOnInit() :void {

      this.signupService.getCountry().subscribe(countryList => {
          this.countries = countryList;
          console.log("countries  ===  " + countryList);
      });

  }

  createAccount() : void {
	  	console.log(this.signup.firstname + " ======= >>>>>>>>" + this.signup.country);
      
      this.signupService.createUser(this.signup).subscribe(
          message => {
              this.msg = message.msg;
              if(this.msg === 'Signin Success') {
                  console.log("Signin successfully" + this.msg);
                  this.router.navigate(['/flightSearch']);
              }  else {
                  this.errorMsg = this.msg;
              }

              //this.router.navigate(['./login']);
          },
          err => {
              console.log("Signin Server Error");
          }
      );

      
	  	
  }	
}

