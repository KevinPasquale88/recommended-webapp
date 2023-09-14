import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
import { DashboardControllerService, ImagingControllerService } from 'src/app/api/services';
import { Image, ImageStatistics } from 'src/app/api/models';

@Injectable({
  providedIn: 'root'
})
export class ImagesServicesService {

  constructor(private imagingService: ImagingControllerService,
    private dashboardService:DashboardControllerService,private cookieService: CookieService) { }

    getImage():Observable<Image>{
      return this.imagingService.getRandomImage();
    }

    sendComment(sentence: string, image?: string):Observable<void>{
      return this.imagingService.putComment({
        body:{
          comment: sentence,
          image: image,
          jwt: this.cookieService.get('user')
        }
      });
    }

    getStatistics(): Observable<Array<ImageStatistics>>{
      return this.dashboardService.get();
    }

}
