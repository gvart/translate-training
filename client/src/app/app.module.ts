import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {routing} from "./app.routing";
import { NavbarComponent } from './theme/navbar/navbar.component';
import { FooterComponent } from './theme/footer/footer.component';
import { MenuComponent } from './theme/menu/menu.component';
import { HomeComponent } from './main/home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    MenuComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    routing
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
