import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import { ForgotPassword } from './forgotPassword.model';
import { Message } from './message.model';

@Injectable()
export class ForgotPasswordService {

 constructor (private http: Http) {}


  forgotPassword(forgotPasswordObj: ForgotPassword) {
   
      return this.http.post('http://localhost:8080/forgotPassword', forgotPasswordObj)
        	.map(response => response.json());
  }

}

