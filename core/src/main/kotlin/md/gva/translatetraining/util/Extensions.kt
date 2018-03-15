package md.gva.translatetraining.util

import md.gva.translatetraining.data.Dictionary
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse


fun ServerResponse.BodyBuilder.json() = contentType(MediaType.APPLICATION_JSON_UTF8)


//entity
fun Dictionary.solved(): Boolean {
    return sentences.all { it.solved }
}
