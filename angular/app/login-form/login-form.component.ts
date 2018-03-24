import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Http, Response, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import 'rxjs/add/operator/map'
import 'rxjs/add/operator/toPromise';

import { LoginService } from '../services/loginService-service/login.service';
import { StorageService } from '../storage/storage.service';
import { Login }        from '../model/login/login.model';


interface Message {
    msg : string
}


@Component({
      selector: 'app-login-form',
      templateUrl: './login-form.component.html',
      styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
      
      storage : Map<string, any> ;
      //message : Message;
      loginError = false;
      user = {
          email:"",
          password: ""
      };
      userId : number;
      constructor(
          private _http: Http,
          private route: ActivatedRoute,
          private router: Router,
          private loginService : LoginService,
          private storageService : StorageService
      ) {}

      ngOnInit() {
          this.storage = this.storageService.getStorage();
      }

      loginUser() {
          this.loginService.loginUser(this.user).subscribe(
              message => {
                  if(message.userId > 0) {
                      this.storageService.addToStorage('userId', message.userId);
                      this.storageService.addToStorage('email', message.email);
                      this.router.navigate(['/flightSearch']);

                  } else {
                    this.loginError = true; 
                  }
              },
              err => { console.log("Serve Error : login page"); }
          );
        }


      forgot() {
        this.router.navigate(['/forget']);
      }
  

}
