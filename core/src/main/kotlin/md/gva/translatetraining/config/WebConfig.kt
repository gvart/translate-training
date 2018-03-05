package md.gva.translatetraining.config

import md.gva.translatetraining.web.DictionaryHandler
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
class WebConfig {

    companion object {
        const val MAIN_ROUTE = "/api/dictionary"
    }

    @Bean
    fun routes(dictController: DictionaryHandler): RouterFunction<ServerResponse> {
        return route(GET(MAIN_ROUTE), HandlerFunction<ServerResponse>(dictController::all))
                .andRoute(POST(MAIN_ROUTE), HandlerFunction<ServerResponse>(dictController::create))
                .andRoute(GET(MAIN_ROUTE + "/{id}"), HandlerFunction<ServerResponse>(dictController::get))
                .andRoute(GET(MAIN_ROUTE + "/sentence/{id}"), HandlerFunction<ServerResponse>(dictController::update))
                .andRoute(DELETE(MAIN_ROUTE + "/{id}"), HandlerFunction<ServerResponse>(dictController::delete))
    }
}