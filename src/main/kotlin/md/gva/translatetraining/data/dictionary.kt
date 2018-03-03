package md.gva.translatetraining.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author Gladîș Vladlen on 3/2/18.
 */
@Document(collection = "dictionary")
data class Dictionary (
           @Id var id: String? = null,
               var name: String = "",
        @DBRef var sentences: List<Sentence> = mutableListOf()
)

fun Dictionary.solved(): Boolean {
        return sentences.all { it.solved }
}