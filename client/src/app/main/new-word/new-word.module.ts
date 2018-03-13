import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {routing} from "../home/home.routing";
import {NewWordComponent} from "./new-word.component";

@NgModule({
  imports: [
    CommonModule,
    routing
  ],
  declarations: [
    NewWordComponent
  ]
})
export class NewWordModule { }
