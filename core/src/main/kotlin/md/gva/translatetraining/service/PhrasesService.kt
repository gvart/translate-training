package md.gva.translatetraining.service

import md.gva.translatetraining.data.Sentence
import md.gva.translatetraining.util.formatRussianCharacters
import org.jsoup.HttpStatusException
import org.jsoup.Jsoup
import org.springframework.stereotype.Service
import java.util.ArrayList
import java.util.logging.Logger

/**
 * @author Gladîș Vladlen on 3/2/18.
 */

@Service
class PhrasesService {
    private val log = Logger.getLogger("PhrasesService")
    private val trashTags = listOf<String>("span", "sup", "i", "small")

    fun getPhrases(word: String): List<Sentence> {
        val sentences = ArrayList<Sentence>()

        try {
            val doc = Jsoup.connect("https://dict.leo.org/russisch-deutsch/$word").get()

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
        }catch (ex: HttpStatusException) {
            log.warning(ex.message)
        }

        //second site
        val doc = Jsoup.connect("https://en.pons.com/translate?q=$word&l=deru&in=&lf=de#examples").get()

        doc.select("div.content-inner > dl.dl-horizontal").forEach({
            val sentence = Sentence()

            val de = it.select("dt > div > div.source > span").text()
            val ru = it.select("dd > div > div.target").text().formatRussianCharacters()

            sentence.deutsch = de
            sentence.russian = ru
            sentences.add(sentence)
        })

        return sentences
    }
}
