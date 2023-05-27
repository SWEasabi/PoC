import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    private loggedIn = false;

    isLoggedIn(): boolean {
        return this.loggedIn;
    }
    isAuthenticated(): boolean {
        // Check if token exists in local storage or cookie
        const token = localStorage.getItem('token');
        return !!token; // Returns true if token exists, false otherwise
    }

    getToken(): string {
        // Retrieve token from local storage or cookie
        return localStorage.getItem('token');
    }

    logout(): void {
        // Remove token from local storage or cookie
        localStorage.removeItem('token');
        // Redirect to authentication page or any other desired page
    }
}
