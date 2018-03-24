import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/map';

@Injectable()
export class StorageService {

		private storage  = new Map<string, any>();
		
		constructor() { }


		getStorage() : Map<string, any> {
			return this.storage;
		}	

		addToStorage(key, data) {
			this.storage.set(key, data);
		}

		remove(key) {
			this.storage.delete(key);
		}
}