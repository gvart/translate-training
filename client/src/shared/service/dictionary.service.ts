import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Dictionary, DictionaryDTO} from "../model/dictionary.model";


@Injectable()
export class DictionaryService {
  private URL = "/api/dictionary";

  constructor(private http: HttpClient) {

  }

  public saveWord(dto: DictionaryDTO): Observable<Dictionary> {
    return this.http.post<Dictionary>(this.URL, dto);
  }

  public listWords(): Observable<Dictionary[]> {
    return this.http.get<Dictionary[]>(this.URL);
  }

  public getWord(id: string): Observable<Dictionary> {
    return this.http.get<Dictionary>(`${this.URL}/${id}`);
  }

  public markSentenceAsSolved(id: string): Observable<void> {
    return this.http.get<void>(`${this.URL}/sentence/${id}`);
  }

  public deleteWord(id: string): Observable<void> {
    return this.http.delete<void>(`${this.URL}/${id}`);

  }


}
