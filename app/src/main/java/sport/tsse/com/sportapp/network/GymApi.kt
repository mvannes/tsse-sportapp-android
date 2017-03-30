package sport.tsse.com.sportapp.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class GymApi {

    val service: GymService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://145.28.152.217:8080/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        service = retrofit.create(GymService::class.java)
    }
}