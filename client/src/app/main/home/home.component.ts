import { Component, OnInit } from '@angular/core';
import {Dictionary} from "../../../shared/model/dictionary.model";
import {DictionaryService} from "../../../shared/service/dictionary.service";
import {TranslateService} from "@ngx-translate/core";
import {DictionaryUtil} from "../../../shared/util/dictionary.util";
import {NotificationsService} from "angular2-notifications";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  words: Dictionary[];
  private dictionaryUtil: DictionaryUtil;

  constructor(private translate: TranslateService,
              private notificationService: NotificationsService,
              private service: DictionaryService) { }

  ngOnInit() {
    this.dictionaryUtil = new DictionaryUtil();

    this.translate.setDefaultLang('en');
    this.translate.use('en');
    this.service.listWords().subscribe((res) => this.words = res);
  }

  deleteWord(dictionary: Dictionary) {
    this.service.deleteWord(dictionary.id).subscribe(() => {
      this.words.splice(this.words.indexOf(dictionary), 1);
      let notification = this.notificationService.success("Removed successful",
        `Word '${dictionary.name}' removed.`);
      setTimeout(() => this.notificationService.remove(notification.id), 2500);
    });
  }

}
