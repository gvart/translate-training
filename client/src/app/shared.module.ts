import { NgModule } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {FlexLayoutModule} from '@angular/flex-layout';
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    FormsModule,
    AngularFontAwesomeModule,
    FlexLayoutModule
  ],
  exports: [
    FormsModule,
    AngularFontAwesomeModule,
    FlexLayoutModule
  ]
})
export class SharedModule { }
