package sport.tsse.com.sportapp.exercise.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_exercise_detail.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.storage.repository.ExerciseRepository

/**
 * Created by mitchelldevries on 28/05/2017.
 */
class ExerciseDetailFragment : Fragment() {

    companion object {
        val ARG_EXERCISE_ID = "exercise_id"

        fun newInstance(exerciseId: Int): ExerciseDetailFragment {
            val args = Bundle()
            args.putInt(ARG_EXERCISE_ID, exerciseId)

            val fragment = ExerciseDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_exercise_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments.getInt(ARG_EXERCISE_ID)
        val repository = ExerciseRepository(context)
        val exercise = repository.findOne(id)

        detailTitle.text = exercise?.name
        detailCategory.text = exercise?.category
        detailDescription.text = exercise?.description
    }
}