package sport.tsse.com.sportapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class Api {

    val service: ApiService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.178.68:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(ApiService::class.java)
    }
}