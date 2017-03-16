package sport.tsse.com.sportapp.exercise.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.exercise.list.ExerciseAdapter.ExerciseViewHolder
import java.util.*

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseAdapter(val exercises: ArrayList<Exercise>,
                      val listener: (Exercise) -> Unit) : RecyclerView.Adapter<ExerciseViewHolder>() {

    override fun onBindViewHolder(holder: ExerciseViewHolder?, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            ExerciseViewHolder(LayoutInflater.from(parent?.context)
                    .inflate(android.R.layout.simple_list_item_1, parent))


    override fun getItemCount() = exercises.size

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(exercise: Exercise, listener: (Exercise) -> Unit) = with(itemView) {
            
        }
    }
}