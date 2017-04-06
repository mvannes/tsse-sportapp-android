package sport.tsse.com.sportapp.exercise

import sport.tsse.com.sportapp.data.Exercise

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExercisePresenterImpl(val view: ExerciseView) : ExercisePresenter {
    override fun finish() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadExercises() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onExerciseClicked(exercise: Exercise) {
        view.showExercise(exercise)
    }

    fun
    fun onSuccess(exercises: List<Exercise>) {
        view.hideProgress()
        view.setExercises(exercises)
    }

    fun onFailure(t: Throwable) {
        view.hideProgress()
        view.showError(t.message!!)
    }

}