import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login-entry',
  templateUrl: './login-entry.component.html',
  styleUrls: ['./login-entry.component.scss']
})
export class LoginEntryComponent implements OnInit {

  register: boolean = false;

  constructor(private _router: Router, private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
  }

  goToAdmin() {
    this._router.navigate(['/login']);
  }

  goToSurvey() {
    this.register = true;
  }

  consenso(value: boolean) {
    this.register = false;

    if (value) {
      this._router.navigate(['/input']);
    }
  }

}
