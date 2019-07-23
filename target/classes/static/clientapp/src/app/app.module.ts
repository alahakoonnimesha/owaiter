import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule ,Routes} from '@angular/router';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from "@angular/forms";


import { AppComponent } from './app.component';
import { MenubarComponent } from './components/menubar/menubar.component';
import { ClientHomeComponent } from './components/client-home/client-home.component';
import { ClientSignupComponent } from './components/client-signup/client-signup.component';
import { ClientLoginComponent } from './components/client-login/client-login.component';


const appRoutes: Routes = [
 
 { path: 'menubar', component:MenubarComponent },
 { path: 'clienthome', component:ClientHomeComponent },
 { path: 'clientlogin', component:ClientLoginComponent },
 { path: 'clientsignup', component:ClientSignupComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    MenubarComponent,
    ClientHomeComponent,
    ClientSignupComponent,
    ClientLoginComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes,{enableTracing:true}),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
