import { Results, ResultsServiceService } from './../service/data/results-service.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  name='';
  resultsFromService:string='';
  constructor(private route:ActivatedRoute, private service:ResultsServiceService) { }

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name'];
  }

  handleResults(response:any){
    this.resultsFromService = response.message;
  }

  getResultsFromService(){
    this.service.executeResultsRestService().subscribe(response => this.handleResults(response));
  }



}
