import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {PatientSchedulerComponent} from "./patient-scheduler/patient-scheduler.component";
import {StatsComponent} from "./stats/stats.component";

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'scheduler',
    component: PatientSchedulerComponent
  },
  {
    path: 'stats',
    component: StatsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
