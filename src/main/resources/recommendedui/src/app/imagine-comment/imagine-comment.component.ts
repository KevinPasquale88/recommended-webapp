import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ImagesServicesService } from '../services/image-services/images-services.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Image } from '../api/models';

@Component({
  selector: 'app-imagine-comment',
  templateUrl: './imagine-comment.component.html',
  styleUrls: ['./imagine-comment.component.scss']
})
export class ImagineCommentComponent implements OnInit {
  sentence: string = '';
  stepsImagine=1;
  totSteps = 10;

  componentWidth='0%';

  emotions: string[] = ['Anger','Calm','Depression','Disgust','Happiness'];

  imageShow: SafeUrl | undefined;
  sentenceEmpty: boolean = false;

  imageName: string | undefined;

  selectedEmotion: string = '';

  constructor(private _router: Router, private _activatedRoute: ActivatedRoute,
     private imageService:ImagesServicesService, private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.downloadInfo();
  }
  
  skip(){
    this.downloadInfo();
  }

  nextPhoto(){
    this.downloadInfo ();
  }

  onSubmit() {
      this.imageService.sendComment(this.sentence, this.imageName).subscribe();
      this.sentence = '';
      this.stepsImagine += 1;
      this.downloadInfo();
  }

  async downloadInfo(){
    
    let percentage=100/this.totSteps*this.stepsImagine;
    if(this.stepsImagine > 10){
      this._router.navigate(['/']);
    }else{
      this.componentWidth=percentage+'%';
      this.imageService.getImage().subscribe(
        (data: Image)=>{
          console.log(data);
          this.imageName = data.image;
          let objectURL = 'data:image/png;base64,' + data.data;
          this.imageShow = this.sanitizer.bypassSecurityTrustUrl(objectURL);
        });
    }
  }
}
