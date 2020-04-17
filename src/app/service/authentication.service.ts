import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private route : Router) {}

  userAuth(username, password){
    if(username === 'chandan' || username === 'Chandan'){
      this.route.navigate(['sandal', username])
    }
  }
}
