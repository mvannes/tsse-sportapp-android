package sport.tsse.com.sportapp.exercise.list

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_exercise_list.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.exercise.detail.ExerciseDetailActivity
import sport.tsse.com.sportapp.network.Api

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseListFragment : Fragment(), ExerciseListView {

    private lateinit var presenter: ExerciseListPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_exercise_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ExerciseListPresenter(this, Api(), context)
        presenter.start()
    }

    override fun loadExercises(exercises: List<Exercise>) {
        exerciseListRecyclerView.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = ExerciseListAdapter(exercises) {
                startActivity(ExerciseDetailActivity.newIntent(context, it.id))
                val c = context as AppCompatActivity
                c.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
    }

    override fun showProgress() {
        if (isAdded) {
            exerciseListProgress.visibility = View.VISIBLE
            exerciseListRecyclerView.visibility = View.GONE
        }
    }

    override fun hideProgress() {
        if (isAdded) {
            exerciseListProgress.visibility = View.GONE
            exerciseListRecyclerView.visibility = View.VISIBLE
        }
    }

    override fun showError(errorMessage: String) {
        if (isAdded) {
            Snackbar.make(view!!, errorMessage, Snackbar.LENGTH_LONG).show()
        }
    }

}