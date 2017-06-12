package sport.tsse.com.sportapp.exercise.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_exercise_detail.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.storage.repository.ExerciseRepository

/**
* tsse-sportapp-android
*
* @author Mitchell de Vries
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

        Glide.with(context)
                .asDrawable()
                .load(R.drawable.bench_press) // TODO Change to actual URL from the api.
                .into(detailImage)

        detailTitle.text = exercise?.name
        detailCategory.text = exercise?.category
        detailDescription.text = exercise?.description
        setFavorite(exercise?.favorite == 1)

        detailFavorite.setOnClickListener {
            if (repository.findOne(id)?.favorite == 1) {
                setFavorite(false)
                exercise?.favorite = 0
                repository.update(exercise!!)
            } else {
                setFavorite(true)
                exercise?.favorite = 1
                repository.update(exercise!!)
            }
        }
    }

    private fun setFavorite(favorite: Boolean) {
        if (favorite) {
            detailFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_clicked))
        } else {
            detailFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite))
        }
    }
}