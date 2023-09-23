import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../models/user';
import { UserServicesService } from '../services/user-services/user-services.service';

@Component({
  selector: 'app-generic-inputs',
  templateUrl: './generic-inputs.component.html',
  styleUrls: ['./generic-inputs.component.scss']
})
export class GenericInputsComponent implements OnInit {

  genders = ['Male', 'Female', 'Unknow'];
  model = new User('', '', 0, false);

  constructor(private _router: Router, private _activatedRoute: ActivatedRoute
    , private cookieService: CookieService, private userServicee: UserServicesService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.userServicee.registerUser({
      age: this.model.age,
      gender: this.model.gender,
      nickName: this.model.nickName,
      auth: this.model.auth
    }).subscribe((res) => {
      if (res) {
        this.cookieService.set('user', res);
        this._router.navigate(['/imaging']);
      }
    });
  }

  goToHomePage() {
    this._router.navigate(['/firstlogin']);
  }

}
