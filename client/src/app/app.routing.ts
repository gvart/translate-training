import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";

export const routes: Routes = [
  {
    path: '',
    loadChildren: './main/home/home.module#HomeModule'
  },
  {
    path: 'new-word',
    loadChildren: './main/new-word/new-word.module#NewWordModule'
  },
  {
    path: '**',
    redirectTo: '',
    pathMatch: 'full'
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
