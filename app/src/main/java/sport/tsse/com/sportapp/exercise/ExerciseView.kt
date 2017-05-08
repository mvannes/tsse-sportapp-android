package sport.tsse.com.sportapp.exercise

import sport.tsse.com.sportapp.data.Exercise

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
interface ExerciseView {

    fun showProgress()

    fun hideProgress()

    fun showError(errorMessage: String)

    fun setExercises(exercises: List<Exercise>)

    fun showExercise(exercise: Exercise)

}