package sport.tsse.com.sportapp.exercise.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_exercise_list.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.exercise.detail.ExerciseDetailActivity
import java.util.*

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_exercise_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exercises: ArrayList<Exercise> = ArrayList()

        for (i in 1..100) exercises.add(Exercise("Exercise " + i, "Muscle Group"))

        if (exercises.size != 0) {
            exerciseListEmptyTextView.visibility = View.GONE
        } else {
            exerciseListEmptyTextView.visibility = View.VISIBLE
        }

        exerciseListRecyclerView.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
//            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            layoutManager = linearLayoutManager
            adapter = ExerciseAdapter(exercises) {
                startActivity(Intent(context, ExerciseDetailActivity::class.java))
            }
        }
    }
}