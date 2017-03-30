package sport.tsse.com.sportapp.network

import retrofit2.Call
import retrofit2.http.GET
import sport.tsse.com.sportapp.data.Exercise

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
interface ApiService {

    @GET("exercises")
    fun getAllExercises(): Call<List<Exercise>>

    @GET("exercises/{id}")
    fun getOneExercise(): Exercise
}
