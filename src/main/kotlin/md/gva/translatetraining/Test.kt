package md.gva.translatetraining

import md.gva.translatetraining.data.Dictionary
import md.gva.translatetraining.repository.DictionaryRepository
import md.gva.translatetraining.repository.SentenceRepository
import md.gva.translatetraining.service.PhrasesService
import md.gva.translatetraining.service.TranslateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Test(service: TranslateService,
           @Value("\${yandex.translate.key}") val key: String,
           val phrasesService: PhrasesService,
           val dictionaryRepository: DictionaryRepository,
           val sentenceRepository: SentenceRepository) : CommandLineRunner{

    override fun run(vararg args: String?) {
      //  var message = service.translate(key = key, text = "Du beleuchtest solche Fragen immer so umständlich").execute().body()
      //  println(message!!.text)

        val phrases = phrasesService.getPhrases("Wissenschaft")

        val dictionary = Dictionary()

        dictionary.name = "Wissenschaft"
        dictionary.sentences = phrases

        dictionaryRepository.save(dictionary)

    }

}