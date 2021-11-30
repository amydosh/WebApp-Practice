import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { NgForm } from '@angular/forms';

export class Question{
  constructor(
    public questionnum: string,
    public description: string,
    public answer: string
  ){}
}

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

 search : string = '';

 questions = [
  new Question('Question 1','How many states are there in the US?','50'),
  new Question('Question 2','What animal says "meow"','cat'),
  new Question('Question 3','What color is a school bus?','yellow')
]

  constructor(private router: Router) { }

  ngOnInit(): void { 
  }


  addQuestions(){
    this.router.navigate(['questions',-1])
  }






}
