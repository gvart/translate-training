import {RouterModule, Routes} from "@angular/router";
import {NewWordComponent} from "./new-word.component";

const routes: Routes = [
  {
    path: '',
    component: NewWordComponent,
  }
];

export const routing = RouterModule.forChild(routes);
