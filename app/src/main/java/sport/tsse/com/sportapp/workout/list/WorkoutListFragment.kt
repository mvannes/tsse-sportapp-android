package sport.tsse.com.sportapp.workout.list

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.fragment_workout_list.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.Workout
import sport.tsse.com.sportapp.network.Api
import sport.tsse.com.sportapp.workout.add.AddWorkoutActivity
import sport.tsse.com.sportapp.workout.detail.WorkoutDetailActivity

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
        presenter = WorkoutListPresenter(this, Api(), context)
        presenter.start()

    }

    override fun loadWorkouts(workouts: List<Workout>) {
        workoutListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = WorkoutListAdapter(workouts) {
                startActivity(WorkoutDetailActivity.newIntent(context, it.id))
                val c = context as AppCompatActivity
                c.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
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
        }
    }

    override fun startAddWorkoutActivity() {
        startActivity(AddWorkoutActivity.newIntent(context))
        val c = context as AppCompatActivity
        c.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}