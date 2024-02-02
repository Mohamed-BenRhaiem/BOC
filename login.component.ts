import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../appServices/AuthService/auth-service.service';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { EmployeeServiceService } from '../../appServices/EmployeeService/employee-service.service';

@Component({
  selector: 'app-login',
  template: `
    <form (ngSubmit)="onSubmit(loginForm)" class="text-center border border-dark p-5 container shadow" #loginForm="ngForm">
      <p class="h4 mb-4">Connecter</p>
      <!-- Email -->
      <input type="email" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail" [(ngModel)]="credentials.username" name="username" required>
      <!-- Password -->
      <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password" [(ngModel)]="credentials.password" name="password" required>
      <div class="d-flex justify-content-around">
        <div>
          <!-- Forgot password -->
          <a href="">Forgot password?</a>
        </div>
      </div>
      <!-- Sign in button -->
      <button color="info" block="true" class="btn btn-success" type="submit">Connecter</button>
      <!-- Register -->
      <p>Not a member?
        <a class="link" routerLink="/registrer" (click)="goToRegister()">Registrer</a>
      </p>
    </form>
  `,
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  private apiUrl = 'http://localhost:8081';
  credentials: {
    username: any,
    password: any
} = {
    username: '',
    password: ''
};

  constructor(private employeService:EmployeeServiceService,private http: HttpClient, private authService: AuthService, private router: Router) {}

  onSubmit(form: NgForm) {
    if (form.valid) {
      this.authService.authenticate(this.credentials,()=>{
        if(this.authService.isAuthenticated)
        {
          this.router.navigateByUrl('/employes')
        }
      })
    }
  }

  goToRegister() {
    this.router.navigate(['/registrer']);
  }

  
}
