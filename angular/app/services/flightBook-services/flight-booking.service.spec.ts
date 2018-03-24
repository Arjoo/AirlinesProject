import { TestBed, inject } from '@angular/core/testing';

import { FlightBookingService } from './flight-booking.service';

describe('FlightBookingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FlightBookingService]
    });
  });

  it('should be created', inject([FlightBookingService], (service: FlightBookingService) => {
    expect(service).toBeTruthy();
  }));
});
