import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
    if(this.model.user== 'admin' && this.model.password == 'admin'){
      this._router.navigate(['/dashbord']);
    }else{
      this.loginFailed = true;
    }
  }

  goto(){
    this._router.navigate(['/input']);
  }
}
