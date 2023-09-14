import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import {  User } from 'src/app/api/models';
import { UserControllerService } from 'src/app/api/services/user-controller.service';

@Injectable({
  providedIn: 'root'
})
export class UserServicesService {

  constructor(private userControllerService: UserControllerService) { }

  auth(user: string, pwd: string) : Observable<string> {
    return this.userControllerService.auth({
      body: {
        pwd: pwd,
        user: user
      }
    });
  }

  registerUser(user: User): Observable<string>{
    return this.userControllerService.userSession({body: user});
  }
}
