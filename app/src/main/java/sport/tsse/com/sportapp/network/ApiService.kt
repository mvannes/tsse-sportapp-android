package sport.tsse.com.sportapp.network

import retrofit2.Call
import retrofit2.http.GET
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.Schedule
import sport.tsse.com.sportapp.data.User
import sport.tsse.com.sportapp.data.Workout

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
interface ApiService {

    @GET("exercises")
    fun getAllExercises(): Call<List<Exercise>>

    @GET("schedule")
    fun getAllSchedules(): Call<List<Schedule>>

    @GET("workouts")
    fun getAllWorkouts(): Call<List<Workout>>

    @GET("users")
    fun getAllUsers(): Call<List<User>>
}
