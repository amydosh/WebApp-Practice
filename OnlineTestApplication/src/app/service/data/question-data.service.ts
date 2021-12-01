
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class Quiz {
  constructor(public quiz:any){
  }
}

@Injectable({
  providedIn: 'root'
})
export class QuestionDataService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };  

  constructor(private http: HttpClient) { }

  createQuestion(quiz:any){
    return this.http.post<Quiz>('http://localhost:8080/quiz',quiz)
  }

  executeQuestionRestService(){
    return this.http.get<Quiz>('http://localhost:8080/quiz');
  }
}