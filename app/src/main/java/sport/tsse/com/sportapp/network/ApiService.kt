package sport.tsse.com.sportapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.data.Workout

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
interface ApiService {

    @GET("exercises")
    fun getAllExercises(): Call<List<Exercise>>

    @GET("schedules")
    fun getAllSchedules(): Call<List<Schedule>>

    @GET("schedules/{id}")
    fun getSchedule(@Path("id") id: Long): Call<Schedule>

    @GET("workout")
    fun getAllWorkouts(): Call<List<Workout>>
}
