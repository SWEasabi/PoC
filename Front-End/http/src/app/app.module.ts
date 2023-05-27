import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from './app.component';
import { LampButtonComponent } from '../app/components/lamp-button/lamp-button.component';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

/* ROUTES */

const routes: Routes = [
  { path: '', redirectTo: '/authentication', pathMatch: 'full' },
  { path: 'authentication', component: AuthenticationComponent },
];


@NgModule({
 declarations: [
   AppComponent,
   LampButtonComponent,
   AuthenticationComponent,
 ],
 imports: [
   BrowserModule,
   HttpClientModule,
   RouterModule.forRoot(routes),
   AppRoutingModule,
   FormsModule
 ],
 exports: [RouterModule],
 providers: [],
 bootstrap: [AppComponent]
})
export class AppModule { } 