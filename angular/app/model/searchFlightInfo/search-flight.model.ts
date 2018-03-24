
export class SearchFlight {
    constructor(
        public isOneWay: boolean,
        public from:string,
        public to:string,
        public numberOfPassenger: number,
        public passengerClass : string,
        public depart:Date,
        public rturn?:Date,
        public flightId?:number,
        public flightNumber?:string
        
    ) {}
}