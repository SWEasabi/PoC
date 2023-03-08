import { Component,OnInit,ChangeDetectorRef } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Component({
 selector: 'app-root',
 templateUrl: './app.component.html',
 styleUrls: ['./app.component.css']
})

export class AppComponent {
 private data:any = []
 constructor(private http: HttpClient,private cdr: ChangeDetectorRef) {}
 


}