package md.gva.translatetraining.service

import md.gva.translatetraining.data.Dictionary
import md.gva.translatetraining.data.DictionaryDTO
import md.gva.translatetraining.repository.DictionaryRepository
import md.gva.translatetraining.repository.SentenceRepository
import md.gva.translatetraining.util.solved
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author Gladîș Vladlen on 3/3/18.
 */
@Service
class DictionaryService(
        private val phrasesService: PhrasesService,
        private val sentenceRepository: SentenceRepository,
        private val dictionaryRepository: DictionaryRepository) {

    fun save(word: DictionaryDTO): Mono<Dictionary> {
        if(!word.name.isNullOrEmpty()) {
            val item = dictionaryRepository.findByNameIgnoreCase(word.name).block()
            if (item == null) {
                val sentences = phrasesService.getPhrases(word.name)

                if(sentences.isNotEmpty()) {
                    val saveAll = sentenceRepository.saveAll(sentences).collectList()
                    val dictionary = Dictionary()

                    dictionary.name = word.name
                    dictionary.sentences = saveAll.block()!!
                    return dictionaryRepository.save(dictionary)
                }
                return Mono.empty()
            }
        }
        return Mono.empty()
    }

    fun findAllUnsolved(): Flux<Dictionary> {
        return dictionaryRepository.findAll().filter { !it.solved() }
    }

    fun findAll(): Flux<Dictionary> {
        return dictionaryRepository.findAll()
    }

    fun markSentenceAsSolved(id: String): Mono<Void> {
        val sentence = sentenceRepository.findById(id).blockOptional()

        if(sentence.isPresent) {
            val data = sentence.get()
            data.solved = true
            sentenceRepository.save(data).subscribe()
        }

        return Mono.empty()
    }

    fun findById(id: String): Mono<Dictionary> {
        return dictionaryRepository.findById(id)
    }

    fun delete(id: String): Mono<Any> {
        val dictionary = dictionaryRepository.findById(id).block()
        if (dictionary != null) {
            dictionary.sentences.forEach { sentenceRepository.delete(it).block() }
            dictionaryRepository.delete(dictionary).block()
            return Mono.just(true)
        }

        return Mono.empty()
    }

}