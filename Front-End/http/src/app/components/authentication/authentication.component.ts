import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observer } from 'rxjs';
import { Router } from '@angular/router';



@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent {
  username: string;
  password: string;
  errorMessage: string;

  constructor(private http: HttpClient , private router: Router) { }

  login() {
    const credentials = {
      username: this.username,
      password: this.password
    };

    const loginObserver: Observer<any> = {
      next: (response) => {
        // Save token in local storage or cookie
        localStorage.setItem('token', response.token);
        // Redirect to CRUD operation page or any other desired page
      },
      error: (error) => {
        this.errorMessage = error.message;
      },
      complete: () => {
        // Route me to the home page
        this.router.navigate(['/home']);

      }
    };
    
    // Make the login API call using the observer
      this.http.post<any>('http://blablabla/login', credentials).subscribe(loginObserver);
  }
}
