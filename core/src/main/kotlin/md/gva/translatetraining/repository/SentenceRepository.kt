package md.gva.translatetraining.repository

import md.gva.translatetraining.data.Sentence
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * @author Gladîș Vladlen on 3/2/18.
 */
interface SentenceRepository: ReactiveMongoRepository<Sentence, String>