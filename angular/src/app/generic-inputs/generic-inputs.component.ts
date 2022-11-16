import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../models/user';

@Component({
  selector: 'app-generic-inputs',
  templateUrl: './generic-inputs.component.html',
  styleUrls: ['./generic-inputs.component.scss']
})
export class GenericInputsComponent implements OnInit {

  genders = ['Male', 'Female', 'Unknow'];
  model = new User('', '', 0);


  constructor(private _router: Router, private _activatedRoute: ActivatedRoute
    , private cookieService: CookieService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    
    this.cookieService.set('user', JSON.stringify(this.model));
    this._router.navigate(['/imaging']);
  }

}
