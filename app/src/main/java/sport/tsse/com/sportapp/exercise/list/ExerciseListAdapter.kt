package sport.tsse.com.sportapp.exercise.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_exercise.view.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.exercise.list.ExerciseListAdapter.ExerciseViewHolder

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseListAdapter(val exercises: List<Exercise>,
                          val listener: (Exercise) -> Unit) : RecyclerView.Adapter<ExerciseViewHolder>() {

    override fun onBindViewHolder(holder: ExerciseViewHolder?, position: Int) {
        holder?.bind(exercises[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_exercise, parent, false))
    }

    override fun getItemCount() = exercises.size

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(exercise: Exercise, listener: (Exercise) -> Unit) = with(itemView) {
            exerciseListItemTitleTextView.text = exercise.name
            exerciseListItemInfoTextView.text = exercise.category
            setOnClickListener { listener(exercise) }
        }
    }
}