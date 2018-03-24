import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

import { Login } from '../../model/login/login.model';

@Injectable()
export class LoginService {

  constructor (private http: Http) {}

	loginUser(loginObj: Login) {
 
      return this.http.post('http://localhost:8080/login', loginObj)
        .map((res:Response) => res.json());
  }

}
