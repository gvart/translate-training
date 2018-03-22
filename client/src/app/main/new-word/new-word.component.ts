import {Component, OnInit} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {DictionaryService} from "../../../shared/service/dictionary.service";
import {DictionaryDTO} from "../../../shared/model/dictionary.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-word',
  templateUrl: './new-word.component.html',
  styleUrls: ['./new-word.component.css']
})
export class NewWordComponent implements OnInit {
  word: DictionaryDTO;

  constructor(private translate: TranslateService,
              private service: DictionaryService,
              private router: Router) { }

  ngOnInit() {
    this.translate.setDefaultLang('en');
    this.translate.use('en');
    this.word = new DictionaryDTO("");
  }

  saveWord() {
    this.service.saveWord(this.word)
      .subscribe( (response) => this.router.navigate(['/']),
                  (error) =>  alert("dasasd"));
  }

}
