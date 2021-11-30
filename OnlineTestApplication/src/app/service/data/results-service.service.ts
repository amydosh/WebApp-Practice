import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Results {
  constructor(
    public name:string,
    public results:string
    ){}
}

@Injectable({
  providedIn: 'root'
})
export class ResultsServiceService {

  constructor(private http: HttpClient) { }
  executeResultsRestService(){
    return this.http.get<Results>('http://localhost:8080/results');
  }
}
