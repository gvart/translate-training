package md.gva.translatetraining

import md.gva.translatetraining.data.Dictionary
import md.gva.translatetraining.repository.DictionaryRepository
import md.gva.translatetraining.repository.SentenceRepository
import md.gva.translatetraining.service.PhrasesService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Test(
           val phrasesService: PhrasesService,
           val dictionaryRepository: DictionaryRepository,
           val sentenceRepository: SentenceRepository) : CommandLineRunner{

    override fun run(vararg args: String?) {

    }

}