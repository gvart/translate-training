import {Dictionary} from "../model/dictionary.model";

export class DictionaryUtil {

  public solvedPercentage(dictionary: Dictionary): string {
    const unsolved = dictionary.sentences.filter((item) => !item.solved).length;
    console.log(unsolved);
    return ((dictionary.sentences.length - unsolved) / 100).toFixed() ;
  }
}
