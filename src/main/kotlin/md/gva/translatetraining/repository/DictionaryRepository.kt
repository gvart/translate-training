package md.gva.translatetraining.repository

import md.gva.translatetraining.data.Dictionary
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * @author Gladîș Vladlen on 3/2/18.
 */
interface DictionaryRepository: MongoRepository<Dictionary, String>