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
    var workouts = emptyList<Workout>()

    override fun start() {
        view.showProgress()
        api.service.getAllWorkouts().enqueue(this)

        workouts = repository.findAll()

        if (workouts.isNotEmpty()) {
            updateView()
        }
    }

    override fun onResponse(call: Call<List<Workout>>?, response: Response<List<Workout>>?) {
        if (response?.isSuccessful!!) {
            workouts = response.body()
            repository.save(workouts)
        }
        updateView()
    }

    override fun onFailure(call: Call<List<Workout>>?, t: Throwable?) {
        updateView()
        view.showError("Error occurred while fetching new data: " + t?.message!!)
    }

    private fun updateView() {
        view.hideProgress()
        view.loadWorkouts(workouts)
    }
}
