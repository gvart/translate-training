import { Component, OnInit } from '@angular/core';
import {Dictionary} from "../../../shared/model/dictionary.model";
import {DictionaryService} from "../../../shared/service/dictionary.service";
import {TranslateService} from "@ngx-translate/core";
import {DictionaryUtil} from "../../../shared/util/dictionary.util";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private words: Dictionary[];
  private dictionaryUtil: DictionaryUtil;

  constructor(private translate: TranslateService,
              private service: DictionaryService) { }

  ngOnInit() {
    this.dictionaryUtil = new DictionaryUtil();

    this.translate.setDefaultLang('en');
    this.translate.use('en');
    this.service.listWords().subscribe((res) => this.words = res);
  }

}
