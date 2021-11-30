import { Results, ResultsServiceService } from './../service/data/results-service.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {

  result='';
  testStatus='';
  testStatusMessage:string = '';
  constructor(private route:ActivatedRoute, private service: ResultsServiceService) { }

  ngOnInit(): void {
    //this.result = this.route.snapshot.params['result'];
  }

  // handlePassTest(response:any){
  //   this.testStatus=response.message;
  // }

  // handleFailTest(response:any){
  //   this.testStatus=response.message;
  // }

  // getMessage(){
  //   // this.service.executeQuizRestService.subscribe((response: any) => this.handlePassTest(response));
  //   console.log('You passed the test!');
  // }



}
