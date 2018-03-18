import {Component, Inject} from "@angular/core";
import {MAT_SNACK_BAR_DATA, MatSnackBarRef} from "@angular/material";
import {Sentence} from "../../../shared/model/sentence.model";
import {DictionaryService} from "../../../shared/service/dictionary.service";

@Component({
  selector: 'app-test-snackbar',
  templateUrl: './test-snackbar.component.html'
})
export class TestSnackbarComponent {
  public ref: MatSnackBarRef<TestSnackbarComponent>;

  private sentence: Sentence;
  constructor(@Inject(MAT_SNACK_BAR_DATA) public data: Sentence,
              private service:DictionaryService) {
    this.sentence = data;
  }

  markAsTranslated() {
    this.service.markSentenceAsSolved(this.sentence.id).subscribe(() => this.close());
  }

  close(){
    this.ref.dismiss();
  }
}
