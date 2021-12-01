import { Question } from 'src/app/quiz/quiz.component';
import { QuestionDataService } from './../service/data/question-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  constructor(private route:ActivatedRoute, private service: QuestionDataService) { }

  ngOnInit(): void {
  }


  saveQuestion() {
    console.log()
  }

  addQuestion(question:Question){
    console.log()
  }



}
