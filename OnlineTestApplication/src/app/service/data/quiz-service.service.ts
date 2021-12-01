import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class Quiz {
  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  };

  constructor(
    public message: string
    ){}
}

@Injectable({
  providedIn: 'root'
})


export class QuizServiceService {

  constructor(private http: HttpClient) { }

  executeQuizRestService(){
    return this.http.get<Quiz>('http://localhost:8080/quiz');
  }


}
