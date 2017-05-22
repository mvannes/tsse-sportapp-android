package sport.tsse.com.sportapp.workout.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_workout.view.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Workout
import sport.tsse.com.sportapp.workout.list.WorkoutListAdapter.WorkoutViewHolder

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class WorkoutListAdapter(val workouts: List<Workout>,
                         val listener: (Workout) -> Unit) : RecyclerView.Adapter<WorkoutViewHolder>() {

    override fun onBindViewHolder(holder: WorkoutViewHolder?, position: Int) {
        holder?.bind(workouts[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WorkoutViewHolder {
        return WorkoutViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_workout, parent, false))
    }

    override fun getItemCount() = workouts.size

    class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(workout: Workout, listener: (Workout) -> Unit) = with(itemView) {
            workoutName.text = workout.name
            workoutDescription.text = workout.category
            setOnClickListener { listener(workout) }
        }
    }
}