package md.gva.translatetraining.data

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.convert.MongoConverter
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

/**
 * @author Gladîș Vladlen on 3/2/18.
 */
@Document(collection = "dictionary")
data class Dictionary (
        @Id
        var id: String? = null,

        var name: String? = null,
        @CreatedDate
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        var createdDate: LocalDateTime = LocalDateTime.now(),
        @DBRef
        var sentences: List<Sentence> = mutableListOf()
)

data class DictionaryDTO (var name:String)

