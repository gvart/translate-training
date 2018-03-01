package md.gva.translatetraining

import md.gva.translatetraining.service.TranslateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Test(@Autowired val service: TranslateService,
           @Value("\${yandex.translate.key}") val key: String) : CommandLineRunner{

    override fun run(vararg args: String?) {
        var message = service.translate(key = key, text = "Du beleuchtest solche Fragen immer so umständlich").execute().body()
        println(message!!.text)
    }

}