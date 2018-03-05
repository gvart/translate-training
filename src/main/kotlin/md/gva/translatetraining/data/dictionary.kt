package md.gva.translatetraining.data

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

/**
 * @author Gladîș Vladlen on 3/2/18.
 */
@Document(collection = "dictionary")
data class Dictionary (
           @Id var id: String? = null,
           var name: String? = null,
           @CreatedDate var createdDate: LocalDateTime = LocalDateTime.now(),
           @DBRef var sentences: List<Sentence> = mutableListOf()
)

fun Dictionary.solved(): Boolean {
        return sentences.all { it.solved }
}

data class DictionaryDTO (var name:String)