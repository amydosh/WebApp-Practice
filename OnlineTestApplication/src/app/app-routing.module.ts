import { FailComponent } from './fail/fail.component';
import { PassComponent } from './pass/pass.component';
import { TakequizComponent } from './takequiz/takequiz.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { AdminComponent } from './admin/admin.component';
import { ErrorComponent } from './error/error.component';
import { LogoutComponent } from './logout/logout.component';
import { ReviewComponent } from './review/review.component';
import { ResultsComponent } from './results/results.component';
import { QuizComponent } from './quiz/quiz.component';
import { MenuComponent } from './menu/menu.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NgForm } from '@angular/forms';

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'login', component: LoginComponent},
  {path:'welcome/:name', component: WelcomeComponent},
  {path:'menu', component: MenuComponent},
  {path:'quiz', component: QuizComponent},
  {path:'results', component: ResultsComponent},
  {path:'review', component: ReviewComponent},
  {path:'logout', component: LogoutComponent},
  {path:'admin', component: AdminComponent},
  {path:'admindash',component: AdmindashComponent},
  {path:'takequiz', component: TakequizComponent},
  {path:'pass', component: PassComponent},
  {path:'fail', component:FailComponent},
  {path:'**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
