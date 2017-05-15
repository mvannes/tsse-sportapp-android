package sport.tsse.com.sportapp.workout.list

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.base.BasePresenter
import sport.tsse.com.sportapp.data.Workout
import sport.tsse.com.sportapp.network.Api

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class WorkoutListPresenter(val view: WorkoutListView,
                           val api: Api): BasePresenter, Callback<List<Workout>> {

    private val TAG = "WorkoutListPresenter";

    override fun start() {
        view.showProgress()
        api.service.getAllWorkouts().enqueue(this)
    }

    fun onSuccess(workouts: List<Workout>) {
        view.hideProgress()
        view.populateView(workouts)
    }

    fun onFailure(t: Throwable) {
        view.hideProgress()
        view.showError(t.message!!)
    }

    override fun onResponse(call: Call<List<Workout>>?, response: Response<List<Workout>>?) {
        if (response?.isSuccessful!!) {
            val exercises = response.body()
            onSuccess(exercises)
            Log.d(TAG, "onResponse: " + exercises.toString())
        }
    }

    override fun onFailure(call: Call<List<Workout>>?, t: Throwable?) {
        onFailure(t!!)
        Log.e(TAG, "onFailure: " + t)
    }

}
