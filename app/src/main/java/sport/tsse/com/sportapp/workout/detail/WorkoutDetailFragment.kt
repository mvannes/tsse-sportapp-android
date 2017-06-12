package sport.tsse.com.sportapp.workout.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_workout_detail.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.storage.repository.WorkoutRepository
import sport.tsse.com.sportapp.exercise.detail.ExerciseDetailActivity
import sport.tsse.com.sportapp.exercise.list.ExerciseListAdapter

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class WorkoutDetailFragment : Fragment() {


    companion object {
        private val ARG_WORKOUT_ID = "workout_id"

        fun newInstance(workoutId: Int): WorkoutDetailFragment {
            val args = Bundle()
            args.putInt(ARG_WORKOUT_ID, workoutId)

            val fragment = WorkoutDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_workout_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments.getInt(ARG_WORKOUT_ID)
        val repository = WorkoutRepository.getInstance(context)
        val workout = repository.findOne(id)

        detailWorkoutName.text = workout?.name
        addWorkoutDescriptionEditText.text = workout?.description

        addExerciseListRecyclerView.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = ExerciseListAdapter(workout?.exercises!!) {
                startActivity(ExerciseDetailActivity.newIntent(context, it.id))
                val c = context as AppCompatActivity
                c.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
    }
}
