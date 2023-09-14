import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GenericInputsComponent } from './generic-inputs/generic-inputs.component';
import { ImagineCommentComponent } from './imagine-comment/imagine-comment.component';
import { LoginEntryComponent } from './login-entry/login-entry.component';
import { LoginComponent } from './login/login.component';
import { AdviceComponent } from './advice/advice.component';

const routes: Routes = [
  { path: 'input', component: GenericInputsComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: '', component: LoginEntryComponent },
  { path: 'login', component: LoginComponent },
  { path: 'imaging', component: ImagineCommentComponent },
  { path: 'firstlogin', component: LoginEntryComponent },
  { path: 'advice', component: AdviceComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
