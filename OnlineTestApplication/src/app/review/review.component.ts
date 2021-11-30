import { ReviewDataService } from './../service/data/review-data.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap} from '@angular/router';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  data = this.reviewDataService.getData();
  check1: string = this.data.answered1;
  check2: string = this.data.answered2;
  check3: string = this.data.answered3;
  check4: string = this.data.answered4;
  result:boolean = false;
  
  constructor(
    private reviewDataService:ReviewDataService,
    private router: Router) { 
      if(this.data.answered1==='2' 
      && this.data.answered2 ==='10'
      && this.data.answered3==='green'
      && this.data.answered4==='meow'){
        this.router.navigate(['pass']);
      } else {
        this.router.navigate(['fail']);
      }
   }

  ngOnInit(): void {
  }



}
