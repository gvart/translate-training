import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home', pathMatch: 'full',
  },
  {
    path: 'home',
    loadChildren: './main/home/home.module#HomeModule'
  },
  {
    path: 'new-word',
    loadChildren: './main/new-word/new-word.module#NewWordModule'
  },
  {
    path: 'test',
    loadChildren: './main/test/test.module#TestModule'
  }
];

export const routing = RouterModule.forRoot(routes);
