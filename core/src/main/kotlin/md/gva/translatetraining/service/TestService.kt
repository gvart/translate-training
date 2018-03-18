package md.gva.translatetraining.service

import md.gva.translatetraining.data.Sentence
import md.gva.translatetraining.repository.SentenceRepository
import org.springframework.stereotype.Service

@Service
class TestService (val sentenceRepository: SentenceRepository) {

    fun generateTest(): List<Sentence> {
        sentenceRepository.count()
        val list = sentenceRepository.findBySolved(false).collectList().block()!!.toList().shuffled()
        val size = list.size

        if(size == 0) {
            return emptyList()
        }
        else if(size >= 10){
            return list.subList(0, 9)
        }

        return list.subList(0, list.size - 1 )
    }

}