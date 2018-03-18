import {RouterModule, Routes} from "@angular/router";
import {TestComponent} from "./test.component";

const routes: Routes = [
  {
    path: '',
    component: TestComponent,
  }
];

export const routing = RouterModule.forChild(routes);
