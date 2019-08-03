import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from "./services/auth.service";
import {HttpModule} from "@angular/http";
import {AccountService} from "./services/account.service";
import { ProfileComponent } from './components/profile/profile.component';
import {routing} from "./app.routing";
import {FacebookModule} from "ngx-facebook";
import {UrlPermission} from "./urlPermission/url.permission";
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { ChangePassComponent } from './components/change-pass/change-pass.component';
import { RefreshProfileComponent } from './utilities/refresh-profile/refresh-profile.component';
import { AdminComponent } from './components/admin/admin.component';
import { ChangeServiceComponent } from './components/change-service/change-service.component';
import { ManagerComponent } from './components/manager/manager.component';






@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    EditProfileComponent,
    ChangePassComponent,
    RefreshProfileComponent,
    AdminComponent,
    ChangeServiceComponent,
    ManagerComponent,



  ],
  imports: [
    BrowserModule,HttpModule,FormsModule,routing, FacebookModule.forRoot(),
  ],
  providers: [AuthService,AccountService,UrlPermission],
  bootstrap: [AppComponent]
})
export class AppModule { }
