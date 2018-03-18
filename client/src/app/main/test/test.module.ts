import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {HttpClient} from "@angular/common/http";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {TestComponent} from "./test.component";
import {SharedModule} from "../../shared.module";
import {routing} from "./test.routing";
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {TestSnackbarComponent} from "./test-snackbar.component";
import {MatButtonModule} from "@angular/material";
import {TestService} from "../../../shared/service/test.service";
import {DictionaryService} from "../../../shared/service/dictionary.service";

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/test/', '.json');
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
    MatButtonModule,
    MatSnackBarModule,
    routing
  ],
  declarations: [
    TestComponent,
    TestSnackbarComponent
  ],
  entryComponents: [
    TestSnackbarComponent
  ],
  providers: [
    TestService,
    DictionaryService
  ]
})
export class TestModule { }
