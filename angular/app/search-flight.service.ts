import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/map';


@Injectable()
export class SearchFlightService {

	constructor (private http: Http) {}
	

	flights() {
		let headers = new Headers({ 'Content-Type': 'application/json' });
		//let options = new RequestOptions({ headers: headers });
		//let body = JSON.stringify("");
			return this.http.get('http://localhost:8080/searchFlight',headers)
				.map((res:Response) => res.json());
	}
}
