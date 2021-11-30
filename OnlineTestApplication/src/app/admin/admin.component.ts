import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  username: string='';
  password: string='';
  invalidLogin=false;
  errorMessage='Invalid Credentials!';
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  handleAdminLogin() {
    if(this.username==='admin' && this.password ==='admin'){
      // Navigate to Welcome Component:
      this.router.navigate(['admindash']);
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }
  }

}
