import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {UrlPermission} from "./urlPermission/url.permission";
import {EditProfileComponent} from "./components/edit-profile/edit-profile.component";
import {ChangePassComponent} from "./components/change-pass/change-pass.component";
import {RefreshProfileComponent} from "./utilities/refresh-profile/refresh-profile.component";
import {AdminComponent} from "./components/admin/admin.component";
import {ManagerComponent} from "./components/manager/manager.component";
import {QuestionComponent} from "./components/question/question.component";
import {AnswerComponent} from "./components/answer/answer.component";


const appRoutes: Routes = [
  {path: 'profile', component: ProfileComponent, canActivate: [UrlPermission]},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'edit-profile', component: EditProfileComponent},
  {path: 'change-pass', component: ChangePassComponent},
  {path: 'ref-prof', component: RefreshProfileComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'manager', component: ManagerComponent},
  {path: 'fields', component: QuestionComponent},
  {path: 'responses', component: AnswerComponent},

  {path: 'profile/admin', redirectTo: '/admin'},
  {path: 'profile/manager', redirectTo: '/manager'},
  // otherwise redirect to profile
  {path: '**', redirectTo: '/login'}
];

export const routing = RouterModule.forRoot(appRoutes);
