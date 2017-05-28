package sport.tsse.com.sportapp.exercise.list

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.base.BasePresenter
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.storage.repository.ExerciseRepository
import sport.tsse.com.sportapp.network.Api

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseListPresenter(val view: ExerciseListView,
                            val api: Api,
                            val context: Context) : BasePresenter, Callback<List<Exercise>> {

    private val repository = ExerciseRepository(context)

    override fun start() {
        view.showProgress()
        api.service.getAllExercises().enqueue(this)
        if (!repository.isEmpty()) {
            view.loadExercises(repository.findAll())
            view.hideProgress()
        }
    }

    override fun onResponse(call: Call<List<Exercise>>?, response: Response<List<Exercise>>?) {
        if (response?.isSuccessful!!) {
            val exercises = response.body()
            for (exercise in exercises) {
                repository.save(exercise)
            }
            view.loadExercises(repository.findAll())
            view.hideProgress()
        }
    }

    override fun onFailure(call: Call<List<Exercise>>?, t: Throwable?) {
        view.hideProgress()
        view.showError("Error occurred while fetching new data: " + t?.message!! + ".")
    }

}
