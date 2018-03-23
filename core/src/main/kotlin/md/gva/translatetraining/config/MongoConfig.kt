package md.gva.translatetraining.config

import md.gva.translatetraining.bean.MongoInMemory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoConfig {

    @Bean
    fun mongoInMemory(@Value("\${spring.data.mongodb.port}") port: Int,
                      @Value("\${spring.data.mongodb.host}") host: String): MongoInMemory {
        return MongoInMemory(port, host)
    }

}