import { Router } from '@angular/router';
import { QuizComponent } from './../quiz/quiz.component';
import { Component, OnInit } from '@angular/core';
import { Question } from './../quiz/quiz.component'

@Component({
  selector: 'app-takequiz',
  templateUrl: './takequiz.component.html',
  styleUrls: ['./takequiz.component.css']
})

export class TakequizComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }


  saveAndReview() {
      this.router.navigate(['review'])
  }

}
