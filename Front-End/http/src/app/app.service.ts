import { HttpClient, HttpStatusCode } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StatusData } from './model';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  

  constructor(private http:HttpClient) {}

  getData$(){
    const url ='/lamps/1'
    return this.http.get<StatusData>(url);
  }

  toggleLamp$(status: StatusData['status']){
    return this.http.put<string>('/lamps/1', {
      status : status === 'On' ? 'Off' : 'On'})
  }
}

