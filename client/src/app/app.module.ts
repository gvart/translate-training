import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {routing} from "./app.routing";
import {MatSidenavModule, MatToolbarModule, MatButtonModule} from "@angular/material";
import {FlexLayoutModule} from '@angular/flex-layout';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { NewWordComponent } from './main/new-word/new-word.component';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    FlexLayoutModule,
    AngularFontAwesomeModule,
    routing
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
