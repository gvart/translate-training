package md.gva.translatetraining.config

import md.gva.translatetraining.web.DictionaryHandler
import md.gva.translatetraining.web.TestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
@EnableWebFlux
open class WebConfig {

    companion object {
        const val DICTIONARY_ROUTE = "/api/dictionary"
        const val TEST_ROUTE = "/api/test"
    }

    @Bean
    open fun routes(dictController: DictionaryHandler, testController: TestHandler): RouterFunction<ServerResponse> {
        return route(GET(DICTIONARY_ROUTE), HandlerFunction<ServerResponse>(dictController::all))
                .andRoute(POST(DICTIONARY_ROUTE), HandlerFunction<ServerResponse>(dictController::create))
                .andRoute(GET("$DICTIONARY_ROUTE/{id}"), HandlerFunction<ServerResponse>(dictController::get))
                .andRoute(GET("$DICTIONARY_ROUTE/sentence/{id}"), HandlerFunction<ServerResponse>(dictController::update))
                .andRoute(DELETE("$DICTIONARY_ROUTE/{id}"), HandlerFunction<ServerResponse>(dictController::delete))
                .andRoute(GET(TEST_ROUTE), HandlerFunction<ServerResponse>(testController::getTest))
    }
}