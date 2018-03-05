//package md.gva.translatetraining.config
//
//import md.gva.translatetraining.service.TranslateService
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import retrofit2.Retrofit
//import retrofit2.converter.jackson.JacksonConverterFactory
//
//@Configuration
//class RetrofitConfig(@Value("\${yandex.translate.key}")
//                     val key: String) {
//
//    @Bean
//    fun httpServiceFactory(): Retrofit {
//        return Retrofit.Builder()
//                .addConverterFactory(JacksonConverterFactory.create())
//                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
//                .build()
//    }
//
//    @Bean
//    fun translateService(): TranslateService {
//        return httpServiceFactory().create(TranslateService::class.java)
//    }
//
//}