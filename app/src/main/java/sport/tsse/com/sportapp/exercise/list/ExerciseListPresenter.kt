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

    private val repository = ExerciseRepository.getInstance(context)
    private var exercises = emptyList<Exercise>()

    override fun start() {
        view.showProgress()
        api.service.getAllExercises().enqueue(this)

        exercises = repository.findAll()

        if (exercises.isNotEmpty()) {
            updateView()
        }
    }

    override fun onResponse(call: Call<List<Exercise>>?, response: Response<List<Exercise>>?) {
        if (response?.isSuccessful!!) {
            exercises = response.body()
            repository.save(exercises)
        }
        updateView()
    }

    override fun onFailure(call: Call<List<Exercise>>?, t: Throwable?) {
        updateView()
        view.showError("Error occurred while fetching new data: " + t?.message!! + ".")
    }

    private fun updateView() {
        view.hideProgress()
        view.loadExercises(exercises)
    }

    fun loadFavorites(favorite: Boolean) {
        if (favorite) {
            view.loadExercises(repository.findAll().filter { it.favorite != 0 })
        } else {
            view.loadExercises(exercises)
        }
    }

    fun search(query: String?) {
        if (query.isNullOrBlank()) {
            view.loadExercises(exercises)
        }
        view.loadExercises(exercises.filter { it.name.toLowerCase().contains(query?.toLowerCase().toString()) })
    }
}
