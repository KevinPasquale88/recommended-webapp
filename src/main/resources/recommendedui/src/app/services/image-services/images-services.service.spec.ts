import { TestBed } from '@angular/core/testing';

import { ImagesServicesService } from './images-services.service';

describe('ImagesServicesService', () => {
  let service: ImagesServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImagesServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
