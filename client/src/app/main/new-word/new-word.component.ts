import {Component, OnInit} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {DictionaryService} from "../../../shared/service/dictionary.service";
import {DictionaryDTO} from "../../../shared/model/dictionary.model";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NotificationsService} from "angular2-notifications";

@Component({
  selector: 'app-new-word',
  templateUrl: './new-word.component.html',
  styleUrls: ['./new-word.component.css']
})
export class NewWordComponent implements OnInit {
  form: FormGroup;
  loading: boolean;
  constructor(private translate: TranslateService,
              private service: DictionaryService,
              private notificationService: NotificationsService,
              private formBuilder: FormBuilder,
              private router: Router) { }

  ngOnInit() {
    this.translate.setDefaultLang('en');
    this.translate.use('en');
    this.loading = false;

    this.initForm();
  }

  onSubmit() {
    if(!this.form.invalid) {
      this.saveWord()
    }
  }

  initForm() {
    this.form = this.formBuilder.group({
      name: ['', Validators.required]
    });
  }
  saveWord() {
    this.loading = true;
    this.service.saveWord(this.prepareDictionaryDTO())
      .subscribe((response) => {
          this.router.navigate(['/'])
      } , (error) =>  {
          this.loading = false;
          this.notificationService.error("Not found", "Sentences not found");
          setTimeout(() => this.notificationService.remove(), 5000);
      });
  }

  prepareDictionaryDTO():DictionaryDTO {
    return new DictionaryDTO(this.form.value.name as string)
  }

}
