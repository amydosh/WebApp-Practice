import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string='';
  password: string='';
  invalidLogin=false;
  errorMessage='Invalid Credentials!';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


  // --> Need to update this to look for username/pw combos in db
  handleLogin() {
    if(this.username==='amydosh' && this.password ==='password'){
      // Navigate to Welcome Component:
      this.router.navigate(['welcome',this.username]);
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }
  }

}
