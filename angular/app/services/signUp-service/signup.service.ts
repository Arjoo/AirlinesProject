import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import { Signup } from '../../model/signup/signup.model';

@Injectable()
export class SignupService {

 constructor (private http: Http) {}

	createUser(signupObj: Signup) {
      return this.http.post('http://localhost:8080/createUser', signupObj)
      	  .map(response=> response.json());
	}


	getCountry() {
		return this.http.get('http://localhost:8080/countries')
			.map(response => response.json());
	}
}
