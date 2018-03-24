import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';


import { Login } from './login.model';
import { Message } from './message.model';



@Injectable()
export class LoginService {

	constructor (private http: Http) {}

	loginUser(loginObj: Login) {
		return this.http.post('http://localhost:8080/login',loginObj)
			.map(response => response.json());
	}
}

