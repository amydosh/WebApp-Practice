
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Question } from 'src/app/quiz/quiz.component'

@Injectable({
  providedIn: 'root'
})
export class QuestionDataService {

  constructor(private http: HttpClient) { }

  createQuestion(question:any){
  return this.http.post<Question>('http://localhost:4200/questions',question)
  }
}