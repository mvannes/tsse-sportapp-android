package sport.tsse.com.sportapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class Api {

    val service: ApiService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://145.28.232.249:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(ApiService::class.java)
    }
}