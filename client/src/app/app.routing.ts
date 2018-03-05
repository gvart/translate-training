import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";

export const routes: Routes = [
  {
    path: '**', redirectTo: ''
  },
  {
    path: '', loadChildren: './main/home/home.module#HomeModule'
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes, { useHash: true});
