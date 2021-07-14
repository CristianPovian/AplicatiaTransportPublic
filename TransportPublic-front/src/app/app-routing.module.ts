import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListComponent } from './list/list.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'info/:route_long_name',
    component: ListComponent,
  },
  {
    path: 'info/:route_long_name/:route_short_name',
    component: ListComponent,
  },
  {
    path: 'info/:route_long_name/:route_short_name/:trip_headsign',
    component: ListComponent,
  },
  {
    path: 'info/:route_long_name/:route_short_name/:trip_headsign/:stop',
    component: ListComponent,
  }
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
