package md.gva.translatetraining.util

import md.gva.translatetraining.data.Dictionary
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse


fun ServerResponse.BodyBuilder.json() = contentType(MediaType.APPLICATION_JSON_UTF8)


//entity
fun Dictionary.solved(): Boolean {
    return sentences.all { it.solved }
}

fun String.formatRussianCharacters(): String {
    return toString().replace("и́", "и")
            .replace("э́́", "э")
            .replace("э́", "э")
            .replace("а́", "а")
            .replace("е́", "е")
            .replace("о́", "о")
            .replace("я́́", "я")
            .replace("я́", "я")
            .replace("у́", "у")
            .replace("ы́", "ы")
}