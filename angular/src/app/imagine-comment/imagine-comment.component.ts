import { Component, OnInit } from '@angular/core';
import { readdir } from 'fs/promises';

@Component({
  selector: 'app-imagine-comment',
  templateUrl: './imagine-comment.component.html',
  styleUrls: ['./imagine-comment.component.scss']
})
export class ImagineCommentComponent implements OnInit {
  sentence: string | undefined;
  stepsImagine=1;
  totSteps = 10;

  componentWidth='0%';

  emotions: string[] = ['Anger','Calm','Depression','Disgust','Happiness'];
  pathSrc : string ="../assets/";
  constructor() { }

  ngOnInit(): void {
    this.downloadInfo();
  }
  
  onSubmit() {
    this.stepsImagine += 1;
    this.downloadInfo();
  }

  async downloadInfo(){
    let percentage=100/this.totSteps*this.stepsImagine;
    this.componentWidth=percentage+'%';

   // fs.readdir("../assets/"+this.emotions[Math.floor(Math.random() * this.emotions.length)]  + "/", (err: any, files: any[]) => {
   //   console.log(files);
    //  this.pathSrc = files[Math.floor(Math.random() * files.length)];
   // });
  }
}
