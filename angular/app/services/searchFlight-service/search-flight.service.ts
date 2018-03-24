import { Injectable } 		from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/map';

import { SearchFlight }      from '../../model/searchFlightInfo/search-flight.model';


@Injectable()
export class SearchFlightService {

	constructor (private http: Http) {}
	

	searchFlights(searchFlightInfo: SearchFlight) {
		return this.http.post('http://localhost:8080/searchFlight', searchFlightInfo)
			.map(response => response.json());
	}

	getFromLocations() {
		return this.http.get('http://localhost:8080/fromLocations')
				.map((res:Response) => res.json());
	}

	getToLocations() {
		return this.http.get('http://localhost:8080/toLocations')
				.map((res:Response) => res.json());
	}

	getCategories() {
		return this.http.get('http://localhost:8080/categories')
				.map((res:Response) => res.json());
	}

	bookFlight(flightId) {
		console.log("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmm  " + flightId);
		// return this.http.post('http://localhost:8080/bookFlight', {"flightId" : flightId})
		// 	.map(response => response.json());

	}
}
