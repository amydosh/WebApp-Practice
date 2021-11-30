import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  errorMessage= 'Oops! An error has occured. Please contact the Support Team for assistance.'
  constructor() { }

  ngOnInit(): void {
  }

}
