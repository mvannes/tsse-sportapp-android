package sport.tsse.com.sportapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class Api {

    val service: ApiService
    val httpClient = OkHttpClient.Builder()

    init {
        httpClient.addInterceptor(AuthInterceptor("TSSE", "welkom123"))

        val retrofit = Retrofit.Builder()
                .baseUrl("http://145.28.191.44:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()

        service = retrofit.create(ApiService::class.java)

    }
}