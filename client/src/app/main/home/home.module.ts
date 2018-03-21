import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from "./home.component";
import {routing} from "./home.routing";
import {SharedModule} from "../../shared.module";
import {DictionaryService} from "../../../shared/service/dictionary.service";
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {HttpClient} from "@angular/common/http";
import {TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {MatCardModule} from '@angular/material/card'
import {MatButtonModule} from "@angular/material";

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/home/', '.json');
}

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    TranslateModule.forChild({
      loader: {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [HttpClient]
      },
      isolate: true
    }),
    MatCardModule,
    MatButtonModule,
    MatProgressBarModule,
    routing
  ],
  declarations: [
    HomeComponent
  ],
  providers: [
    DictionaryService
  ]
})
export class HomeModule { }
