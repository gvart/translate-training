package md.gva.translatetraining.web

import md.gva.translatetraining.service.TestService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class TestHandler(private val testService: TestService) {

    fun getTest(req:ServerRequest): Mono<ServerResponse> =
            ok().body(BodyInserters.fromObject(testService.generateTest()))

}