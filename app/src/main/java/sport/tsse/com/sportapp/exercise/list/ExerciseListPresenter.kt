package sport.tsse.com.sportapp.exercise.list

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.base.BasePresenter
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.network.Api

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseListPresenter(val view: ExerciseListView,
                            val api: Api): BasePresenter<Exercise>, Callback<List<Exercise>> {

    private val TAG = "ExerciseListPresenter";

    override fun start() {
        view.showProgress()
        api.service.getAllExercises().enqueue(this)
    }

    override fun onSuccess(items: List<Exercise>) {
        view.hideProgress()
        view.populateView(items)
    }

    override fun onFailure(t: Throwable) {
        view.hideProgress()
        view.showError(t.message!!)
    }

    override fun onResponse(call: Call<List<Exercise>>?, response: Response<List<Exercise>>?) {
        if (response?.isSuccessful!!) {
            val exercises = response.body()
            onSuccess(exercises)
            Log.d(TAG, "onResponse: " + exercises.toString())
        }
    }

    override fun onFailure(call: Call<List<Exercise>>?, t: Throwable?) {
        onFailure(t!!)
        Log.e(TAG, "onFailure: " + t)
    }

}
