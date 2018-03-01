package md.gva.translatetraining.service

import md.gva.translatetraining.domain.Message
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface TranslateService {

    @GET("translate")
    fun translate(@Query("key") key:String,
                  @Query("text") text:String,
                  @Query("lang") lang:String = "de-ru") : Call<Message>
}