import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {  AuthUser } from 'src/app/api/models';
import { UserControllerService } from 'src/app/api/services/user-controller.service';

@Injectable({
  providedIn: 'root'
})
export class UserServicesService {

  constructor(private userControllerService: UserControllerService) { }

  auth(user: string, pwd: string): Observable<string>{
    const authUser: AuthUser = {
      pwd: pwd,
      user: user
    }
    return this.userControllerService.auth({
      body: authUser
    });
  }
}
