import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from './app.component';
import { LampButtonComponent } from './lamp-button/lamp-button.component';

@NgModule({
 declarations: [
   AppComponent,
   LampButtonComponent
 ],
 imports: [
   BrowserModule,
   HttpClientModule
 ],
 providers: [],
 bootstrap: [AppComponent]
})
export class AppModule { } 