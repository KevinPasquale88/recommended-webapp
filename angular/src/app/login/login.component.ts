import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserLogin } from '../models/userlogin';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  model = new UserLogin('', '');
  loginFailed:boolean = false;
  constructor(private _router: Router, private _activatedRoute: ActivatedRoute) { }

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
