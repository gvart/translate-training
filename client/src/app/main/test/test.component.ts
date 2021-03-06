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
  counter: number;
  sentences: Sentence[];
  currentSentence: Sentence;
  testEnds: boolean;
  locked: boolean;

  constructor(private ref: ChangeDetectorRef,
              private translate: TranslateService,
              public snackBar: MatSnackBar,
              private service: TestService,
              private router: Router) { }

  ngOnInit() {
    this.translate.setDefaultLang('en');
    this.translate.use('en');
    this.currentSentence = new Sentence();
  }

  startTest() {
    this.service.getTest().subscribe((res) => {
      this.counter = 0;
      this.sentences = res;

      if(this.sentences.length > 0){
        this.nextWord();
      }
    });
  }

  nextWord() {
    this.testEnds = false;
    const tempSentence = this.sentences[this.counter];

    this.currentSentence.id = tempSentence.id;
    this.currentSentence.deutsch = tempSentence.deutsch;
    this.currentSentence.russian= tempSentence.russian;
    this.currentSentence.solved = tempSentence.solved;
    this.locked = false;
    this.ref.detectChanges();
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
        console.log("yes");
      } else {
        this.testEnds = true;
        this.ref.detectChanges();
      }
    });
  }

}
