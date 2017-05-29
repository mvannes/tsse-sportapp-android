package sport.tsse.com.sportapp.workout.list

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.base.BasePresenter
import sport.tsse.com.sportapp.data.Workout
import sport.tsse.com.sportapp.data.storage.repository.WorkoutRepository
import sport.tsse.com.sportapp.network.Api

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class WorkoutListPresenter(val view: WorkoutListView,
                           val api: Api,
                           val context: Context) : BasePresenter, Callback<List<Workout>> {

    val repository = WorkoutRepository(context)

    override fun start() {
        view.showProgress()
        api.service.getAllWorkouts().enqueue(this)

        val workouts = repository.findAll()
        if (!workouts.isEmpty()) {
            view.hideProgress()
            view.loadWorkouts(workouts)
        }
    }

    override fun onResponse(call: Call<List<Workout>>?, response: Response<List<Workout>>?) {
        if (response?.isSuccessful!!) {
            val workouts = response.body()
            for (workout in workouts) {
                repository.save(workout)
            }
            view.loadWorkouts(repository.findAll())
            view.hideProgress()
        }
    }

    override fun onFailure(call: Call<List<Workout>>?, t: Throwable?) {
        view.hideProgress()
        view.showError("Error occurred while fetching new data: " + t?.message!!)
    }

}
