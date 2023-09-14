import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { take } from 'rxjs';
import { UserLogin } from '../models/userlogin';
import { UserServicesService } from '../services/user-services/user-services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  model = new UserLogin('', '');
  loginFailed:boolean = false;
  constructor(private _router: Router, private _activatedRoute: ActivatedRoute, private userServices: UserServicesService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.userServices.auth(this.model.user, this.model.password)
    .subscribe(
    (res:string)=>{
      if(res === 'OK'){
        this._router.navigate(['/dashboard']);
      }else{
        this.loginFailed = true;
      }
    });
  }

  goto(){
    this._router.navigate(['/input']);
  }
}
