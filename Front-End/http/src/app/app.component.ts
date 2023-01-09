import { Component } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Component({
 selector: 'app-root',
 templateUrl: './app.component.html',
 styleUrls: ['./app.component.css']
})

export class AppComponent {
 private data:any = []
 constructor(private http: HttpClient) {
   
 }

 getData(){
   const url ='http://localhost:8080/lamps'
   this.http.get(url).subscribe((res)=>{
     this.data = res
     console.log(this.data)
   })
 }
}