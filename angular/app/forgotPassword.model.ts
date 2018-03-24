export class ForgotPassword {
	constructor(
		public email?: string,
		public newpassword? : string,
		public confirmpassword? : string
	) {}
}