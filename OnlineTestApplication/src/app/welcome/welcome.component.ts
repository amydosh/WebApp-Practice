import { Welcome, WelcomeDataService } from './../service/data/welcome-data.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  name='';
  welcomeMessageFromService:string='';
  
  constructor(
    private route:ActivatedRoute, 
    private service:WelcomeDataService) 
    { }

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name'];
  }

  handleSuccessfulResponse(response:any){
    this.welcomeMessageFromService = response.message;
  }

  getWelcomeMessage(){
    this.service.executeWelcomeRestService().subscribe(response => this.handleSuccessfulResponse(response));
  }



}
