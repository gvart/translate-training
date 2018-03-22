package md.gva.translatetraining

import md.gva.translatetraining.data.Sentence
import md.gva.translatetraining.util.formatRussianCharacters
import org.jsoup.Jsoup

fun main(args: Array<String>) {
    print(getPhrases("jiho").size)

}

private val trashTags = listOf<String>("span", "sup", "i", "small")

fun getPhrases(word: String): List<Sentence> {
    var doc = Jsoup.connect("https://dict.leo.org/russisch-deutsch/${word.toLowerCase()}").get()
    val sentences = java.util.ArrayList<Sentence>()

    doc.select("#section-phrase > table > tbody").forEach {
        it.select("tr").forEach {
            val sentence = Sentence()
            var flag = true
            it.select("td:nth-child(5), td:nth-child(8)").forEach {
                var html = it.html()
                trashTags.forEach {
                    val openTag =  "<$it>"
                    val closeTag =  "</$it>"
                    val indexOne =  html.indexOf(openTag)
                    val indexTwo =  html.indexOf(closeTag)
                    if(indexOne >= 0 && indexTwo > 0)
                        html = html.removeRange(indexOne, indexTwo + closeTag.length)
                }
                if(flag){
                    sentence.russian = Jsoup.parse(html).text().formatRussianCharacters()
                }else {
                    sentence.deutsch = Jsoup.parse(html).text()
                }
                flag = false
            }

            sentences.add(sentence)
        }
    }

    return sentences
}
