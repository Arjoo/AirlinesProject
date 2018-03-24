export class Person{
    constructor(
    	public from:string,
    	public to:string,
    	public depart:Date,
    	public rturn?:Date,
    	public passengerClass? : string)
    {}
}