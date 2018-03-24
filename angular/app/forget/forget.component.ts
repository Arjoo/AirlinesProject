import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs';

import { ForgotPasswordService } from '../services/forgotPassword-service/forgot-password.service'  ;


interface Message {
    msg : string
}


@Component({
  selector: 'app-forget',
  templateUrl: './forget.component.html',
  styleUrls: ['./forget.component.css']
})
export class ForgetComponent implements OnInit {

  constructor(
      private _http: Http,
      private route: ActivatedRoute,
      private router: Router,
      private forgotPasswordService : ForgotPasswordService 
  ) { }

  ngOnInit() {
  }

  invalidEmailMsg : string;
  forgotObj = {
      email : "",
      newpassword : "",
      confirmpassword : ""
  }

  forgotPassword() : void {
      this.forgotPasswordService.forgotPassword(this.forgotObj).subscribe(
          message => {
              if(message.msg === 'Success') {
                  this.router.navigate(['/flightSearch']);
              } else {
                  this.invalidEmailMsg = message.msg;
              }
              console.log("forgotPassword msg  : " + message.msg);
          },
          err => {
                console.log("forgotPassword Server Error ");
          }
      );
  }
}
