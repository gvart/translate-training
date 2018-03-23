import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NewWordComponent} from "./new-word.component";
import {routing} from "./new-word.routing";
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {HttpClient} from "@angular/common/http";
import {MatInputModule, MatButtonModule, MatCardModule} from "@angular/material";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {SharedModule} from '../../shared.module';
import {DictionaryService} from "../../../shared/service/dictionary.service";
import {SpinnerComponent} from "../../util/spinner/spinner.component";
import {ReactiveFormsModule} from "@angular/forms";

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/new-word/', '.json');
}

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    ReactiveFormsModule,
    TranslateModule.forChild({
      loader: {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [HttpClient]
      },
      isolate: true
    }),

    MatButtonModule,
    MatCardModule,
    MatInputModule,
    routing
  ],
  declarations: [
    NewWordComponent,
    SpinnerComponent
  ],
  providers: [
    DictionaryService
  ]
})
export class NewWordModule { }
