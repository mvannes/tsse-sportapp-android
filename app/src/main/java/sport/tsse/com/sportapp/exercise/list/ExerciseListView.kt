package sport.tsse.com.sportapp.exercise.list

import sport.tsse.com.sportapp.base.BaseView
import sport.tsse.com.sportapp.data.Exercise

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
interface ExerciseListView : BaseView {

   fun loadExercises(exercises: List<Exercise>)

}