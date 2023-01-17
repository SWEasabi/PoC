import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-lamp-button',
  templateUrl: './lamp-button.component.html',
  styleUrls: ['./lamp-button.component.css']
})

export class LampButtonComponent {
  private isOn = false ; 
  private lampStatus : any;
  constructor(private http: HttpClient) {}
  

  toggleLamp(){
    
    this.http.get<any>('http://localhost:8080/lamps/1',{responseType: 'json'}).subscribe(Response => {
      this.lampStatus=Response.status;
      this.http.put<any>('http://localhost:8080/lamps/1',{responseType: 'json', status: Response.status == 'on' ? 'off' : 'on'})
      .subscribe(Response => {
        console.log(Response);
      })
    })
    

   
  }
}
