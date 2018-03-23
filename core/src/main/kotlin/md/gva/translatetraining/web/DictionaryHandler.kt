package md.gva.translatetraining.web

import md.gva.translatetraining.config.WebConfig.Companion.DICTIONARY_ROUTE
import md.gva.translatetraining.data.Dictionary
import md.gva.translatetraining.data.DictionaryDTO
import md.gva.translatetraining.service.DictionaryService
import md.gva.translatetraining.util.json
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Mono
import java.net.URI

private val logger = KotlinLogging.logger {  }

@Component
class DictionaryHandler(private val dictionaryService: DictionaryService) {


    fun all(req: ServerRequest): Mono<ServerResponse> {
        val queryParam = req.queryParam("unsolved")

        if(queryParam.isPresent) {
            return ok().body(dictionaryService.findAllUnsolved(), Dictionary::class.java)
        }

        return ok().body(dictionaryService.findAll(), Dictionary::class.java)
    }

    fun create(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono(DictionaryDTO::class.java)
                .flatMap { this.dictionaryService.save(it) }
                .flatMap {
                    created(URI.create("$DICTIONARY_ROUTE/${it.id}"))
                         .json().body(BodyInserters.fromObject(it))
                }
                .switchIfEmpty( unprocessableEntity().build() )
    }

    fun get(req: ServerRequest): Mono<ServerResponse> {
        return dictionaryService.findById(req.pathVariable("id"))
                .flatMap { dictionary -> ok().body(Mono.just(dictionary), Dictionary::class.java) }
                .switchIfEmpty(notFound().build())
    }

    fun update(req: ServerRequest): Mono<ServerResponse> {
        return dictionaryService.markSentenceAsSolved(req.pathVariable("id"))
                .flatMap { ok().build() }
    }

    fun delete(req: ServerRequest): Mono<ServerResponse> {
        return dictionaryService.delete(req.pathVariable("id"))
                .flatMap { noContent().build() }
                .switchIfEmpty(notFound().build())
    }

}