package sport.tsse.com.sportapp.workout.list

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_workout_list.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.Workout
import sport.tsse.com.sportapp.exercise.detail.ExerciseDetailActivity
import sport.tsse.com.sportapp.exercise.list.ExerciseListPresenter
import sport.tsse.com.sportapp.exercise.list.ExerciseListView
import sport.tsse.com.sportapp.network.Api

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class WorkoutListFragment : Fragment(), WorkoutListView {

    private lateinit var presenter: WorkoutListPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_workout_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = WorkoutListPresenter(this, Api())
        presenter.start()
    }

    override fun populateView(workouts: List<Workout>) {
        workoutListRecyclerView.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = WorkoutListAdapter(workouts) {
//                startActivity(Intent(context, WorkoutDetailActivity::class.java))
            }
        }
    }

    override fun showProgress() {
        if (isAdded) {
            workoutListProgress.visibility = View.VISIBLE
            workoutListRecyclerView.visibility = View.GONE
        }
    }

    override fun hideProgress() {
        if (isAdded) {
            workoutListProgress.visibility = View.GONE
            workoutListRecyclerView.visibility = View.VISIBLE
        }
    }

    override fun showError(errorMessage: String) {
        if (isAdded) {
            AlertDialog.Builder(context)
                    .setTitle("Error")
                    .setMessage(errorMessage)
                    .setPositiveButton(android.R.string.ok, null)
                    .create()
                    .show()
        }
    }

}