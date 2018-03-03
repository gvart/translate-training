package md.gva.translatetraining.service

import md.gva.translatetraining.data.Dictionary
import md.gva.translatetraining.data.solved
import md.gva.translatetraining.repository.DictionaryRepository
import md.gva.translatetraining.repository.SentenceRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

/**
 * @author Gladîș Vladlen on 3/3/18.
 */
@Service
class DictionaryService(
        val phrasesService: PhrasesService,
        val sentenceRepository: SentenceRepository,
        val dictionaryRepository: DictionaryRepository)
{


    fun save(word: String) {
        val sentences = phrasesService.getPhrases(word)
        val saveAll = sentenceRepository.saveAll(sentences).collectList()
        val dictionary = Dictionary()

        dictionary.name = word
        dictionary.sentences = saveAll.block()!!
        dictionaryRepository.save(dictionary).subscribe()
    }

    fun findAllUnsolved(): Flux<Dictionary> {
        return dictionaryRepository.findAll().filter { !it.solved() }
    }

    fun findAll(): Flux<Dictionary> {
        return dictionaryRepository.findAll()
    }

    fun markSentenceAsSolved(id: String) {
        val sentence = sentenceRepository.findById(id).blockOptional()

        if(sentence.isPresent) {
            val data = sentence.get()
            data.solved = true
            sentenceRepository.save(data).subscribe()
        }
    }

}