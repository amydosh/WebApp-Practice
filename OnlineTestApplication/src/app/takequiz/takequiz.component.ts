import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ReviewDataService } from '../service/data/review-data.service';

@Component({
  selector: 'app-takequiz',
  templateUrl: './takequiz.component.html',
  styleUrls: ['./takequiz.component.css']
})

export class TakequizComponent implements OnInit {

  answered1:string='';
  answered2:string='';
  answered3:string='';
  answered4:string='';
  formdata:any;


  constructor(
    private reviewDataService:ReviewDataService,
    private router:Router
    ) { }

  ngOnInit(): void {
    this.formdata = new FormGroup({
      answered1: new FormControl(""),
      answered2: new FormControl(""),
      answered3: new FormControl(""),
      answered4: new FormControl("")
    });
  }
  onClickSubmit(data:any) {
    this.answered1 = data.answered1;
    this.answered2 = data.answered2;
    this.answered3 = data.answered3;
    this.answered4 = data.answered4;
    console.log(this.answered1);
    console.log(this.answered2);
    console.log(this.answered3);
    console.log(this.answered4);
    this.reviewDataService.setData(data);
    this.router.navigateByUrl('review');
  }


  //onClickSubmit(data) {
    //  this.router.navigate(['review', this.answered1, this.answered2, this.answered3, this.answered4]);
  //}

}
