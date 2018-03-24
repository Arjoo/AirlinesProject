import { OnInit, Component, Pipe, PipeTransform} from '@angular/core';
import { DatePipe }             from '@angular/common';
import { DatepickerModule }     from 'ng2-bootstrap';
import { Response }             from '@angular/http';
import { HttpClient}            from '@angular/common/http';
 import { ActivatedRoute, Router }              from '@angular/router';
import 'rxjs/add/operator/map';

import { SearchFlightService }  from '../services/searchFlight-service/search-flight.service';
import { StorageService } from '../storage/storage.service';

import { TodoResponse }         from '../todoResponse.model';
import { Person }               from '../model/person/person.model';
import { Options }              from '../model/options/options.model';
import { SearchFlight }         from '../model/searchFlightInfo/search-flight.model';




@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent implements OnInit {
	   
    storage : Map<string, any>;
    isOneWay : boolean = true;
    noOfPassenger : number = 1;
    lessThanZero : boolean = false;
	  person:Person;
    disabledDate:{dt:Date,mode:string};
    flightList : {};
    fromLocations : {};
    toLocations : {};
    categories : {};
    searchFlightInfo  : SearchFlight;
    rturndate : Date;
    bookFlight : any;
    userId : number;
    userProfileIcon = false;

  
    constructor(
        private http: HttpClient,
        private searchFlightService: SearchFlightService,
        private storageService : StorageService,
        private router: Router,
        private route: ActivatedRoute) { 
            this.rturndate = new Date();
            this.rturndate.setDate(this.rturndate.getDate() + 1);
            this.person = new Person("", "", new Date(), this.rturndate);

            /** 
            this.route.params.subscribe(params => {
                this.userId = params.userId;
                console.log('-------this.email sdfsdfdsf   ---------- ' + this.userId);
            });
            */
    }

    ngOnInit() {

        this.storage = this.storageService.getStorage();
        let userId = this.storage.get('userId');
        if(userId)
          this.userProfileIcon = true;


        this.searchFlightService.getFromLocations().subscribe(fromLocations => {
            this.fromLocations = fromLocations;
            console.log("this.fromCities  ===  " + this.fromLocations);
        }, err => console.log("Server Error : getFromLocations"));

        this.searchFlightService.getToLocations().subscribe(toLocations => {
            this.toLocations = toLocations;
            console.log("this.toLocations  ===  " + this.toLocations);
        }, err => console.log("Server Error : getToLocations"));

        this.searchFlightService.getCategories().subscribe(categoryList => {
              this.categories = categoryList;
              console.log("this.categories  ===  " + this.categories);
            }, err => console.log("Server Error : getCategories"));
     }
  

  chooseOption(option) {
    this.isOneWay = option;

  }
	
	reset() {
      this.person = new Person("", "", new Date());     
	}

	searchFlight() {

      let depart = this.convertDate(this.person.depart);
      let rturn  = this.convertDate(this.person.rturn);
      this.searchFlightInfo = new SearchFlight(
                                    this.isOneWay, this.person.from, this.person.to,
                                    this.noOfPassenger, this.person.passengerClass,
                                    this.person.depart, this.person.rturn)
    
      this.searchFlightService.searchFlights(this.searchFlightInfo).subscribe(
            data => this.flightList = data,
            err => console.log("Server Error : searchFlights"));
  }
	

  book(flightId) {
      console.log("userId is ::::::: from search Flight ::::::: " + this.storage.get('userId'));
      let userId = this.storage.get('userId');
      if(!userId) {
          this.router.navigate(['../login']);
          return;
      }
      
      this.storageService.addToStorage('flightId', flightId);
      this.router.navigate(['../flightbook']);
      
  }

  increment() {
      this.noOfPassenger += 1;
      if(this.noOfPassenger > 1) {
         this.lessThanZero = true;
      }
  }
  
  decrement() {
    this.noOfPassenger -= 1;
    if(this.noOfPassenger == 1) {
      this.lessThanZero = false;
    }
  }

    
  get() {
    this.http.get('http://localhost:8080/todos').subscribe(data => {
      console.log(data);
    });
  }

  convertDate(date) : any {
      var departDatePipe = new DatePipe("en-US");
      let dateInString = departDatePipe.transform(date, 'yyyy-MM-dd');
      return dateInString;
  }


  userProfile() {
        //this.storage.get('userId')
        this.router.navigate(['/userProfile']);
  }
  


}
