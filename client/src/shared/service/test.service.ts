import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Dictionary, DictionaryDTO} from "../model/dictionary.model";
import {Sentence} from "../model/sentence.model";


@Injectable()
export class TestService {
  private URL = "/api/test";

  constructor(private http: HttpClient) {

  }

  public getTest(): Observable<Sentence[]> {
    return this.http.get<Sentence[]>(this.URL);
  }

}
