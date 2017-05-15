package sport.tsse.com.sportapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.Schedule

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

    @GET("schedule")
    fun getAllSchedules(): Call<List<Schedule>>

    @POST("schedule")
    fun saveSchedule(): Call<Schedule>
}
