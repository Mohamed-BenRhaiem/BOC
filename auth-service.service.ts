import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  isAuthenticated:boolean=false;
  constructor(private http:HttpClient,private cookieService:CookieService) {}
  
  
  
  authenticate(credentials: any,callback: any) {
    if(credentials){
      const token = btoa(credentials.username + ":" + credentials.password);
      this.cookieService.set('token',token);
      const headers = new HttpHeaders({
      
        authorization:'Basic ' + token
      });
      let username = "Sami"
      let password = 123
      this.http.get("http://localhost:8081/user",{headers : headers}).subscribe((response:any)=>{

        if(response&&response.username)
          this.isAuthenticated = true;
        else
          this.isAuthenticated = false;

          
          return callback && callback();
        }),
        (e:any)=>{
          console.log(e)
        }
    }
  }
  

}
