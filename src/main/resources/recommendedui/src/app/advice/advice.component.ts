import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-advice',
  templateUrl: './advice.component.html',
  styleUrls: ['./advice.component.scss']
})
export class AdviceComponent implements OnInit {

  @Output() confermo = new EventEmitter<boolean>();


  acconsentire: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  consenso(value: boolean) {
    this.confermo.emit(value);
  }

}
