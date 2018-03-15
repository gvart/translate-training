import {Sentence} from "./sentence.model";

export class Dictionary {
  constructor(
    public id: string,
    public name: string,
    public createDate: any,
    public sentences: Sentence[],
  ) { }
}

export class DictionaryDTO {
  constructor(
    public name: string
  ) {}
}
