package md.gva.translatetraining.repository

import md.gva.translatetraining.data.Dictionary
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * @author Gladîș Vladlen on 3/2/18.
 */
interface DictionaryRepository: ReactiveMongoRepository<Dictionary, String>