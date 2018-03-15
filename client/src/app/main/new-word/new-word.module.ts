import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NewWordComponent} from "./new-word.component";
import {routing} from "./new-word.routing";
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {HttpClient} from "@angular/common/http";
import {MatInputModule, MatButtonModule} from "@angular/material";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {SharedModule} from '../../shared.module';
import {DictionaryService} from "../../../shared/service/dictionary.service";

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/new-word/', '.json');
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

    MatInputModule,
    MatButtonModule,
    routing
  ],
  declarations: [
    NewWordComponent
  ],
  providers: [
    DictionaryService
  ]
})
export class NewWordModule { }
