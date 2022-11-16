import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GenericInputsComponent } from './generic-inputs/generic-inputs.component';
import { FormsModule } from '@angular/forms';
import { ImagineCommentComponent } from './imagine-comment/imagine-comment.component';
import { JwtModule } from '@auth0/angular-jwt';
import { CookieService } from 'ngx-cookie-service';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginEntryComponent } from './login-entry/login-entry.component';
import { ApiModule } from './api/api.module';

@NgModule({
  declarations: [
    AppComponent,
    GenericInputsComponent,
    ImagineCommentComponent,
    LoginComponent,
    DashboardComponent,
    LoginEntryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    JwtModule,
    ApiModule.forRoot({ rootUrl: 'http://localhost:8080/' }),
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
