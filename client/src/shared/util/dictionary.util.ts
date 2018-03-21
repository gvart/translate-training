import {Dictionary} from "../model/dictionary.model";

export class DictionaryUtil {

  public solvedPercentage(dictionary: Dictionary): string {
    const solved = dictionary.sentences.filter((item) => item.solved).length;
    return  (solved / dictionary.sentences.length * 100).toFixed();
  }
}
