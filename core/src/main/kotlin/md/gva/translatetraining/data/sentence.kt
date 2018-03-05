package md.gva.translatetraining.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author Gladîș Vladlen on 3/2/18.
 */
@Document(collection = "sentence")
data class Sentence(
        @Id var id: String? = null,
            var deutsch: String = "",
            var russian: String = "",
            var solved: Boolean = false
)