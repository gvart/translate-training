import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {DictionaryService} from "../../../shared/service/dictionary.service";
import {DictionaryDTO} from "../../../shared/model/dictionary.model";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material";
import {TestSnackbarComponent} from "./test-snackbar.component";
import {Sentence} from "../../../shared/model/sentence.model";
import {TestService} from "../../../shared/service/test.service";

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  private counter: number;
  private sentences: Sentence[];
  private currentSentence: Sentence;
  private testEnds: boolean;
  private locked: boolean;

  constructor(private cd: ChangeDetectorRef,

              private translate: TranslateService,
              public snackBar: MatSnackBar,
              private service: TestService,
              private router: Router) { }

  ngOnInit() {
    this.translate.setDefaultLang('en');
    this.translate.use('en');
  }

  startTest() {
    this.service.getTest().subscribe((res) => {
      this.counter = 0;
      this.sentences = res;
      this.nextWord();
    });

  }

  nextWord() {
    this.currentSentence = null;
    this.currentSentence = this.sentences[this.counter];;
    this.locked = false;
  }

  showTranslation() {
    this.locked = true;
    const ref = this.snackBar.openFromComponent(TestSnackbarComponent, {
      data: this.currentSentence,
      duration: 50000
    });
    ref.instance.ref = ref;

    ref.afterDismissed().subscribe(() => {
      if((this.sentences.length-1) > this.counter) {
        this.counter++;
        this.nextWord();
      } else {
        this.testEnds = true;
      }
    });
  }

}
