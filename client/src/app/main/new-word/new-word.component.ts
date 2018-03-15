import {Component, OnInit} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {DictionaryService} from "../../../shared/service/dictionary.service";
import {DictionaryDTO} from "../../../shared/model/dictionary.model";

@Component({
  selector: 'app-new-word',
  templateUrl: './new-word.component.html',
  styleUrls: ['./new-word.component.css']
})
export class NewWordComponent implements OnInit {
  private word: DictionaryDTO;

  constructor(private translate: TranslateService,
              private service: DictionaryService) { }

  ngOnInit() {
    this.translate.setDefaultLang('en');
    this.translate.use('en');
    this.word = new DictionaryDTO("");
  }

  saveWord() {
    this.service.saveWord(this.word).subscribe( (response) => {
      console.log(response);
    });
  }

}
