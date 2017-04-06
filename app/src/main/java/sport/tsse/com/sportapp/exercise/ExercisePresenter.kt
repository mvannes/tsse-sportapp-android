package sport.tsse.com.sportapp.exercise

import sport.tsse.com.sportapp.data.Exercise

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
interface ExercisePresenter {

    fun finish()

    fun loadExercises()

    fun onExerciseClicked(exercise: Exercise)

}