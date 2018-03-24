
import { Observable } from 'rxjs/Observable';

export class Message {

  constructor(public msg: Observable<any>) {}
}