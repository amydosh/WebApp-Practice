import { QuestionDataService } from './../service/data/question-data.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';

@Component({
  selector: 'app-admindash',
  templateUrl: './admindash.component.html',
  styleUrls: ['./admindash.component.css']
})
export class AdmindashComponent implements OnInit {

  questionFromService = [];
  question:any;
  questionnum:string='';
  questiondesc:string='';
  answer:string='';

  constructor(
    private route: ActivatedRoute,
    private service: QuestionDataService
    ) { }

    // resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
    //   return this.service.executeQuestionRestService().map(response => {
    //     let questions = response['quiz'];
    //     if (questions) {
    //       return questions;
    //     }
    //     console.log('NO questions found');
    //   })
    // }

  ngOnInit() {
    //  = this.route.snapshot.data['questions'];
    this.service.executeQuestionRestService().subscribe(response => this.handleSuccessfulResponse(response));
  }

  handleSuccessfulResponse(response:any){
    this.questionFromService = response;
    console.log(response);
    for(let index=0; index < this.questionFromService.length; index++){
      this.question = this.questionFromService[index];
      console.log(this.question);
      console.log(this.question.questionnum);
      console.log(this.question.questiondesc);
      console.log(this.question.answer);
      }
    }
  }

  // getQuestions(){
  //   this.service.executeQuestionRestService().subscribe(response => this.handleSuccessfulResponse(response));
  // }



