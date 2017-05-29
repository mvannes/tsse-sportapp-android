package sport.tsse.com.sportapp.workout.list

import sport.tsse.com.sportapp.base.BaseView
import sport.tsse.com.sportapp.data.Workout

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
interface WorkoutListView : BaseView {

   fun populateView(workouts: List<Workout>)

}