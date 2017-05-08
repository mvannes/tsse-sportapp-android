package sport.tsse.com.sportapp.exercise

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.Presenter
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.network.Api

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExercisePresenter(val view: ExerciseView, val api: Api): Presenter,  Callback<List<Exercise>> {

    override fun start() {
        view.showProgress()
        api.service.getAllExercises().enqueue(this)
    }

    fun onExerciseClicked(exercise: Exercise) {
        view.showExercise(exercise)
    }

    private fun onSuccess(exercises: List<Exercise>) {
        view.hideProgress()
        view.setExercises(exercises)
    }

    private fun onFailure(t: Throwable) {
        view.hideProgress()
        view.showError(t.message!!)
    }

    override fun onResponse(call: Call<List<Exercise>>?, response: Response<List<Exercise>>?) {
        if (response?.isSuccessful!!) {
            onSuccess(response.body())
        }
    }

    override fun onFailure(call: Call<List<Exercise>>?, t: Throwable?) {
        onFailure(t!!)
    }

}