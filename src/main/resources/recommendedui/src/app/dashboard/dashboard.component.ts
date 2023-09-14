import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Statistics } from '../api/models';
import { ImageStatistics } from '../api/models/image-statistics';
import { ImageWithStatistics } from '../models/image-with-statistics';
import { ImagesServicesService } from '../services/image-services/images-services.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  elems: Array<ImageWithStatistics> = new Array<ImageWithStatistics>();

  constructor(private imagesServicesService: ImagesServicesService, private sanitizer: DomSanitizer) { }

  async ngOnInit(): Promise<void> {
    await this.statistics();
  }

  public async statistics() {
    this.imagesServicesService.getStatistics()
      .subscribe((response: Array<ImageStatistics>) => {
        //need to build charts
        if (response) {
          response.forEach(elem => {
            let elemStatistic = new ImageWithStatistics();
            let objectURL = 'data:image/png;base64,' + elem.image;
            elemStatistic.image = this.sanitizer.bypassSecurityTrustUrl(objectURL);
            if (elem.statisticsList) {
              elem.statisticsList.forEach((statistic) => {
                if (statistic && statistic.user) {
                  if (statistic.user.gender == 'MALE') {
                    this.aggregateStatistics(statistic, elemStatistic.statisticsMapMale);
                  } else if (statistic.user.gender == 'FEMALE') {
                    this.aggregateStatistics(statistic, elemStatistic.statisticsMapFemale);
                  } else {
                    this.aggregateStatistics(statistic, elemStatistic.statisticsMapUnknow);
                  }
                }
              })
            }
            this.elems.push(elemStatistic);
          });
        }

      });
  }

  private aggregateStatistics(statistic: Statistics, statisticsMap: Map<string, Array<number>>): void {
    if (statistic && statistic.emotion && statistic.user && statistic.user.age) {
      statisticsMap.get(statistic.emotion)?.push(statistic.user.age);
    }
  }

  public checkCommentsSize(statisticsMap: Map<string, Array<number>>): boolean {
    let size: boolean = false;
    statisticsMap.forEach((value) => {
      if (value.length > 0) {
        size = true;
      }
    });
    return size;
  }
}
